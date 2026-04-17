package com.dev.sayan.ridehailing.ridehailingmonolith.strategies;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<DriverDto> findMatchingDrivers(RideRequest rideRequest);
}
