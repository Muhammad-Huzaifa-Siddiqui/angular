package com.huzaifa.angular.service;

import com.huzaifa.angular.dto.LoginRequestDto;
import com.huzaifa.angular.dto.RegisterRequestDto;
import com.huzaifa.angular.model.User;
import com.huzaifa.angular.repository.UserRepository;
import com.huzaifa.angular.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Autowired
    AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,JwtProvider jwtProvider){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void signup(RegisterRequestDto registerRequestDto) {
        User user = new User();

        user.setUserName(registerRequestDto.getUsername());
        user.setPassword(encodePassword(registerRequestDto.getPassword()));
        user.setEmail(registerRequestDto.getEmail());
        userRepository.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public void login(LoginRequestDto loginRequestDto) {
       Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        jwtProvider.generateToken()
    }


}
