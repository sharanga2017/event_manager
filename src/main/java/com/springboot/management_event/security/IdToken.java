package com.springboot.management_event.security;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdToken { // Token Oauth2

    private final String accessToken; // access_token

    // Bearer = titulaire / porteur
    private final String tokenType = "Bearer"; // token_type

    private final long expiresIn;  // expires_in


    IdToken(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    @Override
    public String toString() {
        return "IdToken [accessToken=PROTECTED, tokenType=" + tokenType
                + ", expiresIn=" + expiresIn + "]";
    }
}