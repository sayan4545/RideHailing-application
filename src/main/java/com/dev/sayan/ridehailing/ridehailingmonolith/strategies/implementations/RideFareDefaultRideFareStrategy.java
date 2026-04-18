package com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.DistanceService;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.FareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareDefaultRideFareStrategy implements FareCalculationStrategy {
    private final DistanceService distanceService;

    public RideFareDefaultRideFareStrategy(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public Double calculateFare(RideRequest rideRequest) {
        Double distance = distanceService
                .calculateDistance(rideRequest.getPickUpLocation()
                        ,rideRequest.getDropLocation());
        return distance*RIDE_FARE_MULTIPLIER;
    }
}
