package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.SignUpDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.UserDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.User;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.Roles;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.UserRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public AuthServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signUp(SignUpDto signUpDto) {
        User ifExistingUser = userRepository.findByEmail(signUpDto.getEmail());
        if(ifExistingUser!=null){
            throw new RuntimeException("User already exists by the email "+ signUpDto.getEmail());
        }
        User user = modelMapper.map(signUpDto,User.class);
        user.setRoles(Set.of(Roles.RIDER));
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);

    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
