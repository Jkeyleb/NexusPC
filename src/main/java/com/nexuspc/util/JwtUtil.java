package com.nexuspc.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "NEXUSPC_SUPER_SECRET_KEY_2026_NEXUSPC_SUPER_SECRET_KEY_2026"
                            .getBytes()
            );

    private static final long EXPIRATION =
            86400000;

    public static String generateToken(
            String username,
            String role
    ) {

        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION
                        )
                )
                .signWith(SECRET_KEY)
                .compact();
    }

    public static Claims validateToken(
            String token
    ) {

        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}