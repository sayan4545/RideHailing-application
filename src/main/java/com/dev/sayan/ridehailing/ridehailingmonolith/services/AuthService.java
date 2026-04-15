package com.dev.sayan.ridehailing.ridehailingmonolith.services;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.SignUpDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.UserDto;

public interface AuthService {
    void login(String email, String password);

    UserDto signUp(SignUpDto signUpDto);
}
