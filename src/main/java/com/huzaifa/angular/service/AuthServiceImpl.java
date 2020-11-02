package com.huzaifa.angular.service;

import com.huzaifa.angular.dto.RegisterRequestDto;
import com.huzaifa.angular.model.User;
import com.huzaifa.angular.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
}
