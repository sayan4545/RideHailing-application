package com.dev.sayan.ridehailing.ridehailingmonolith.strategies;

import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations.DriverMatchingHighestRatedDriver;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations.DriverMatchingNearestDriverStrategy;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations.RideFareDefaultRideFareStrategy;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations.RideFareSurgePricingRideFareStrategy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class StrategyManager {

    private final DriverMatchingHighestRatedDriver highestRatedDriver;
    private final DriverMatchingNearestDriverStrategy nearestDriver;
    private final RideFareDefaultRideFareStrategy defaultRideFare;
    private final RideFareSurgePricingRideFareStrategy surgePricingRideFareStrategy;

    LocalTime surgeStartTime = LocalTime.of(18,0);
    LocalTime surgeEndTime = LocalTime.of(21,0);
    LocalTime currentTime = LocalTime.now();
    public StrategyManager(DriverMatchingHighestRatedDriver highestRatedDriver, DriverMatchingNearestDriverStrategy nearestDriver, RideFareDefaultRideFareStrategy defaultRideFare, RideFareSurgePricingRideFareStrategy surgePricingRideFareStrategy) {
        this.highestRatedDriver = highestRatedDriver;
        this.nearestDriver = nearestDriver;
        this.defaultRideFare = defaultRideFare;
        this.surgePricingRideFareStrategy = surgePricingRideFareStrategy;
    }

    public DriverMatchingStrategy drivermatchingStrategy(Double riderRating){
        if(riderRating >= 4.8) return highestRatedDriver;
        else{
            return nearestDriver;
        }
    }

    public FareCalculationStrategy calculateFare(){
        if(currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime)) return surgePricingRideFareStrategy;
        else{
            return defaultRideFare;
        }
    }



}
