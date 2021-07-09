package com.springboot.management_event.security;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenProvider {

    private final Algorithm algorithm;

    private final ZoneId zoneId;

    private final String issuer;

    private final long expiration;

    TokenProvider(Algorithm algorithm, String timeZone, String issuer,
                  long expiration) {
        this.algorithm = algorithm;
        zoneId = ZoneId.of(timeZone);
        this.issuer = issuer;
        this.expiration = expiration;
    }

    public IdToken idToken(String subject, List<String> authorities) {
        LocalDateTime now = LocalDateTime.now(zoneId);
        Date issuedAt = toJavaUtilDate(now);
        LocalDateTime expires = now.plusSeconds(expiration);
        Date expiresAt = toJavaUtilDate(expires);
        String accessToken = JWT.create().withIssuer(issuer)
                .withIssuedAt(issuedAt).withExpiresAt(expiresAt)
                .withSubject(subject).withClaim("authorities", authorities)
                .sign(algorithm);
        return new IdToken(accessToken, expiration);
    }

    private Date toJavaUtilDate(LocalDateTime now) {
        return Date.from(now.atZone(zoneId).toInstant());
    }
}