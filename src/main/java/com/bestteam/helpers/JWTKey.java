package com.bestteam.helpers;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTKey {
    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static Key getKey() {
        return key;
    }

    public static Object getClaim(String token, String name) {
        return Jwts.parser().setSigningKey(JWTKey.getKey()).parseClaimsJws(token).getBody().get(name);
    }
}