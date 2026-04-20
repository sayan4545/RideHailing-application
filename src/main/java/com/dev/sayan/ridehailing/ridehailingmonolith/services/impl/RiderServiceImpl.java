package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RiderDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Driver;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Rider;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.User;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.RideRequestStatus;
import com.dev.sayan.ridehailing.ridehailingmonolith.exceptions.ResourceNotFoundException;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.RideRequestRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.RiderRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RiderService;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.DriverMatchingStrategy;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.FareCalculationStrategy;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.StrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {
    private final ModelMapper modelMapper;
    private final StrategyManager strategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;


    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper
                .map(rideRequestDto, RideRequest.class);
        //log.info("RideRequestDto gets converted to Riderequest {}",rideRequest.toString());
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);
        Double fare = strategyManager.calculateFare().calculateFare(rideRequest);
        rideRequest.setFare(fare);
        // save this ride request
        RideRequest persistedRideRequest = rideRequestRepository.save(rideRequest);

        //driverMatchingStrategy.findMatchingDrivers(rideRequest);
        List<DriverDto> drivers = strategyManager
                .drivermatchingStrategy(rider.getRating())
                .findMatchingDrivers(rideRequest);

        //TODO : SEND NOTFICATIONS TO ALL THE MATCHED DRIVERS

        return modelMapper.map(persistedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user) {
        Rider newRider = Rider.builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(newRider);
    }

    @Override
    public Rider getCurrentRider() {
        // TODO : use spring security to get context of the current rider.
        return riderRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException("No rider with the id"));
    }
}
