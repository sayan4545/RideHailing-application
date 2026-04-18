package com.dev.sayan.ridehailing.ridehailingmonolith.strategies;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;

public interface FareCalculationStrategy {
    Double RIDE_FARE_MULTIPLIER = 10.0;
    Double calculateFare(RideRequest rideRequest);
}
