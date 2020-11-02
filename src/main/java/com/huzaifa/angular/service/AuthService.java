package com.huzaifa.angular.service;

import com.huzaifa.angular.dto.RegisterRequestDto;

public interface AuthService {
    void signup(RegisterRequestDto registerRequestDto);
}
