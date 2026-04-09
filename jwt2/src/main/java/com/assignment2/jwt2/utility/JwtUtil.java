package com.assignment2.jwt2.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "secretkey";
    private final long EXPIRATION = 1000*60*10;

    private Claims getClaims(String token)
    {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(String username, String role)
    {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String extractUsername(String token)
    {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token)
    {
        return getClaims(token).get("role", String.class);
    }

    public boolean validateToken(String token)
    {
        try
        {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
