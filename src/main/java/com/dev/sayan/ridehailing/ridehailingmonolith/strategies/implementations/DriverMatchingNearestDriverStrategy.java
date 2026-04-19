package com.dev.sayan.ridehailing.ridehailingmonolith.strategies.implementations;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.DriverRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.DriverMatchingStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {
    private final DriverRepository driverRepository;

    public DriverMatchingNearestDriverStrategy(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<DriverDto> findMatchingDrivers(RideRequest rideRequest) {
        return driverRepository.findTenNearestdrivers(rideRequest.getPickUpLocation());
    }
}
