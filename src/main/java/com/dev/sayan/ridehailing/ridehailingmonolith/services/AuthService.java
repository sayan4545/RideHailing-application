package com.dev.sayan.ridehailing.ridehailingmonolith.services;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.SignUpDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.UserDto;

public interface AuthService {
    String login(String email, String password);

    UserDto signUp(SignUpDto signUpDto);

    DriverDto onBoardNewDriver(Long userId);
}
