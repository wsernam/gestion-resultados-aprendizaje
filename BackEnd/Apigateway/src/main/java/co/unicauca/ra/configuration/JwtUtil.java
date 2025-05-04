/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.configuration;

/**
 *
 * @author ashle
 */


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {


    public static final String SECRET = "638CBE3A90E0303BF3808F40F95A7F02A24B4B5D029C954CF553F79E9EF1DC0384BE681C249F1223F6B55AA21DC070914834CA22C8DD98E14A872CA010091ACC";


    public void validateToken(final String token) {
    try {
        Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token);
    } catch (ExpiredJwtException e) {
        System.out.println("Token expirado");
        throw new RuntimeException("Token expirado", e);
    } catch (SignatureException e) {
        System.out.println("Firma inválida");
        throw new RuntimeException("Firma JWT inválida", e);
    } catch (Exception e) {
        System.out.println("Token inválido: " + e.getMessage());
        throw new RuntimeException("Token inválido", e);
    }
}

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public List<String> extractRoles(String token){
        Claims claims = getClaims(token);
        return claims.get("roles", List.class);
    
    }
    
     public String extractUsername(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getSubject();
    }

    private Claims getClaims(String jwt) {
        return Jwts.parserBuilder()
            .setSigningKey(getSignKey() ) 
            .build()
            .parseClaimsJws(jwt)
            .getBody();
    }
}