package com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.DistanceService;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.FareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingRideFareStrategy implements FareCalculationStrategy {
    private final DistanceService distanceService;

    private static final double SURGE_CALCULATOR = 1.6;

    public RideFareSurgePricingRideFareStrategy(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public Double calculateFare(RideRequest rideRequest) {
        Double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation(),rideRequest.getDropLocation());
        return distance*RIDE_FARE_MULTIPLIER*SURGE_CALCULATOR;
    }
}
