package com.huzaifa.angular.security;


import org.springframework.security.core.Authentication;

public interface JwtProvider {
     String generateToken(Authentication authentication);
}
