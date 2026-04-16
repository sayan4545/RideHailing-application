package com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.FareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareDefaultRideFareStrategy implements FareCalculationStrategy {
    @Override
    public Double calculateFare(RideRequestDto rideRequestDto) {
        return 0.0;
    }
}
