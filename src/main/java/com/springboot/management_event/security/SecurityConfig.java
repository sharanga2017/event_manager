package com.springboot.management_event.security;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${my-app.jwt.provider.time-zone-id}")
    private String timeZoneId;

    @Value("${my-app.jwt.provider.issuer}")
    private String issuer;

    @Value("${my-app.jwt.provider.access-token.expiration}")
    private long expiration;

    @Value("${my-app.jwt.keystore.filename}")
    private String keyStore;

    @Value("${my-app.jwt.keystore.password}")
    private String password;

    @Value("${my-app.jwt.keystore.alias}")
    private String alias;

    @Bean
    public PasswordEncoder passwordEncoder() {

    	return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable unused default configuration:
        http.csrf().disable().httpBasic().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // Apply business requirements:
                .and().authorizeRequests()
                // Authorize any user to access these endpoints:
                .antMatchers(HttpMethod.POST, "/accounts", "/tests/changerole", "/accounts/login")
                .permitAll()
                // Authorize anonymous only to access this endpoint:
                .antMatchers(HttpMethod.GET, "/tests/anonymous-only")
                .anonymous()
                .antMatchers(HttpMethod.GET, "/tests/basic-only")
                .hasRole("BASIC") // ROLE_BASIC
                .antMatchers(HttpMethod.POST, "/organizer/add")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/events/add")
                .hasRole("ORGANIZER")/// Authorize admin role only to access this endpoint:
                .antMatchers(HttpMethod.GET, "/tests/admin-only")
                .hasRole("ADMIN") // ROLE_ADMIN
                .antMatchers(HttpMethod.GET, "/tests/manager-only")
                .hasRole("MANAGER") // ROLE_ADMIN
                .antMatchers(HttpMethod.GET, "/tests/admin-or-manager")
                .hasAnyRole("ADMIN", "MANAGER")




                // Unauthorize any other endpoint (request):
                .anyRequest().fullyAuthenticated()
                // Resource server:
                .and().oauth2ResourceServer().jwt()
                .jwtAuthenticationConverter(jwtConverter());
    }

    @Bean
    protected TokenProvider tokenProvider() {
        KeyPair pair = constructKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic();
        Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
        return new TokenProvider(algorithm, timeZoneId, issuer, expiration);
    }

    private KeyPair constructKeyPair() {
        Resource resource = new ClassPathResource(keyStore);
        char[] password = this.password.toCharArray();
        try (InputStream in = resource.getInputStream()) {
            KeyStore store = KeyStore.getInstance("jks");
            store.load(in, password);
            RSAPrivateCrtKey key = (RSAPrivateCrtKey) store.getKey(alias,
                    password);
            RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(),
                    key.getPublicExponent());
            PublicKey publicKey = KeyFactory.getInstance("RSA")
                    .generatePublic(spec);
            return new KeyPair(publicKey, key);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Converter<Jwt, JwtAuthenticationToken> jwtConverter() {
        return new Converter<>() {

            @Override
            public JwtAuthenticationToken convert(Jwt jwt) {
                Collection<GrantedAuthority> authorities = extractAuthorities(
                        jwt);
                String name = jwt.getClaim("sub");
                return new JwtAuthenticationToken(jwt, authorities, name);
            }

            private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
                Collection<GrantedAuthority> authorities = new HashSet<>();
                List<String> codes = jwt.getClaimAsStringList("authorities");
                if (null != codes && !codes.isEmpty()) {
                    for (String code : codes) {
                        authorities.add(new SimpleGrantedAuthority(code));
                    }
                }
                return authorities;
            }
        };
    }
}

