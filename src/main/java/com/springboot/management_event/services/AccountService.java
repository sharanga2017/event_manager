package com.springboot.management_event.services;

import com.springboot.management_event.model.dtos.AccountCreate;
import com.springboot.management_event.model.dtos.AccountLogin;
import com.springboot.management_event.model.entities.Account;
import com.springboot.management_event.security.IdToken;

import java.util.Collection;
import java.util.List;


public interface AccountService {

    void create(AccountCreate inputs);

    IdToken login(AccountLogin inputs);

    List<Account> getAllAccounts();


     void addRoleByUserName(String username, String roledto);
}
