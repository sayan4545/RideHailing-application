package com.dev.sayan.ridehailing.ridehailingmonolith.strategies;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;

import java.util.List;

public interface DriverMatchingStrategy {
    List<DriverDto> findMatchingDrivers(RideRequestDto rideRequestDto);
}
