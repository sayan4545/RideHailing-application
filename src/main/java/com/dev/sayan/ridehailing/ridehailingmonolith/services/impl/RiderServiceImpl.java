package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RiderDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Rider;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.User;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.RideRequestStatus;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.RideRequestRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RiderService;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.DriverMatchingStrategy;
import com.dev.sayan.ridehailing.ridehailingmonolith.strategies.FareCalculationStrategy;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RiderServiceImpl implements RiderService {
    private final ModelMapper modelMapper;
    private final FareCalculationStrategy fareCalculationStrategy;
    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;

    public RiderServiceImpl(ModelMapper modelMapper, FareCalculationStrategy fareCalculationStrategy, DriverMatchingStrategy driverMatchingStrategy, RideRequestRepository rideRequestRepository) {
        this.modelMapper = modelMapper;
        this.fareCalculationStrategy = fareCalculationStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.rideRequestRepository = rideRequestRepository;
    }

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper
                .map(rideRequestDto, RideRequest.class);
        //log.info("RideRequestDto gets converted to Riderequest {}",rideRequest.toString());
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        Double fare = fareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);
        // save this ride request
        RideRequest persistedRideRequest = rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDrivers(rideRequest);

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
        return newRider;
    }
}
