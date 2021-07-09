package com.springboot.management_event.services;

import java.util.Collection;
import java.util.List;

import com.springboot.management_event.model.dtos.AccountLogin;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.management_event.model.dtos.AccountCreate;
import com.springboot.management_event.model.entities.*;
import com.springboot.management_event.repositories.*;
import com.springboot.management_event.security.BadCredentialsException;
import com.springboot.management_event.security.IdToken;
import com.springboot.management_event.security.TokenProvider;

@Service
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder encoder;
    private final TokenProvider provider;
    private final AccountRepository accounts;
    private final RoleRepository roles;
    public AccountServiceImpl(PasswordEncoder encoder ,
                              TokenProvider provider,
                              AccountRepository accounts,
                              RoleRepository roles
                             ) {
        this.encoder = encoder;
        this.provider = provider;
        this.accounts = accounts;
        this.roles = roles;
    }

    @Override
    public void create(AccountCreate inputs) {
        Account entity = new Account();
        entity.setUsername(inputs.getUsername());
        String raw = inputs.getPassword();
        String encoded = encoder.encode(raw);
        entity.setPassword(encoded);
        entity.setEnabled(true);
        Role defaultRole = roles.findByByDefaultTrue();
        entity.addRole(defaultRole);
        //
        System.out.println(entity);
        //
        accounts.save(entity);
    }    @Override
    public IdToken login(AccountLogin inputs) {
        String username = inputs.getUsername();
        Account entity = accounts.findByUsernameAndEnabledTrue(username)
                .orElseThrow(() -> new BadCredentialsException(
                        "username not found: " + username));
        String encoded = entity.getPassword();
        String raw = inputs.getPassword();
        if (!encoder.matches(raw, encoded)) {
            throw new BadCredentialsException(
                    "bad password for username: " + username);
        }
        // Create a list with the account role's code:
        List<String> authorities = entity.getAllCodes();
        // Return an ID token (oauth 2) with the subject and authorities:
        return provider.idToken(username, authorities);
    }    @Override
    public List<Account> getAllAccounts() {
        List<Account> list = accounts.findAllUsersNative();
       return list;

    }



    public void addRoleByUserName(String username, String roledto){
        Account account = accounts.findByUsernameAndEnabledTrue(username).get();
        String myrole = "ROLE_" +roledto;
        Role role= roles.findByCode(myrole).get();

        account.addRole(role);
        accounts.save(account);
    }


}
