package com.huzaifa.angular.controller;

import com.huzaifa.angular.dto.LoginRequestDto;
import com.huzaifa.angular.dto.RegisterRequestDto;
import com.huzaifa.angular.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signup(@RequestBody RegisterRequestDto registerRequestDto){
        authService.signup(registerRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public void login(@RequestBody LoginRequestDto loginRequestDto){
        authService.login(loginRequestDto);
    }

}
