package com.dev.sayan.ridehailing.ridehailingmonolith.services;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RiderDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Rider;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.User;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    List<RideDto> getAllRides();

    Rider createNewRider(User user);



}
