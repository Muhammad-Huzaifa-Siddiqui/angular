package com.huzaifa.angular.security;


import com.huzaifa.angular.model.User;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtProviderImpl implements JwtProvider{


    public String generateToken(Authentication authentication) {
        User principal = (User)authentication.getPrincipal();
//        return Jwts.builder()
//                .setSubject(principal.getUserName())
//                .signWith(Keys.secretKeyFor())
//                .compact();
    }
}
