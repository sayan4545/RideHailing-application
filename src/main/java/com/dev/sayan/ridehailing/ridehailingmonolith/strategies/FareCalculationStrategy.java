package com.dev.sayan.ridehailing.ridehailingmonolith.strategies;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;

public interface FareCalculationStrategy {
    Double calculateFare(RideRequestDto rideRequestDto);
}
