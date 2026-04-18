package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.SignUpDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.UserDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Rider;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.User;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.Roles;
import com.dev.sayan.ridehailing.ridehailingmonolith.exceptions.RuntimeConflictException;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.UserRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.AuthService;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RiderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    public AuthServiceImpl(ModelMapper modelMapper, UserRepository userRepository, RiderService riderService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.riderService = riderService;
    }

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signUp(SignUpDto signUpDto) {
        User existingUser = userRepository
                .findByEmail(signUpDto.getEmail())
                .orElse(null);
        if(existingUser !=null) throw new RuntimeConflictException("User already present");

        User user = modelMapper.map(signUpDto,User.class);
        user.setRoles(Set.of(Roles.RIDER));
        User savedUser = userRepository.save(user);

        // create rider from user
        Rider newRider = riderService.createNewRider(savedUser);

        // TODO : CREATE WALLET RELATED SERVICES AND IMPLEMENTATION
        return modelMapper.map(savedUser, UserDto.class);

    }

    @Override
    public DriverDto onBoardNewDriver(Long userId) {
        return null;
    }
}
