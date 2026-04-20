package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RiderDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Driver;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Ride;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.RideRequestStatus;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.DriverRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.DriverService;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RideRequestService;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RideService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    private final RideRequestService rideRequestService;
    private final ModelMapper modelMapper;
    private final RideService rideService;

    public DriverServiceImpl(DriverRepository driverRepository, RideRequestService rideRequestService, ModelMapper modelMapper, RideService rideService) {
        this.driverRepository = driverRepository;
        this.rideRequestService = rideRequestService;
        this.modelMapper = modelMapper;
        this.rideService = rideService;

    }

    @Override
    @Transactional
    public RideDto acceptRide(Long rideRequestId) {
        RideRequest rideRequest = rideRequestService.getRideRequestById(rideRequestId);
        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("Already accepted/ cancelled"+ rideRequest.getRideRequestStatus());
        }
        Driver currentDriver = getCurrentDriver();
        if(!currentDriver.getIsAvailable()) throw new RuntimeException("The driver is not availbale");

        RideRequestDto middleRideRequestDto = modelMapper
                .map(rideRequest,RideRequestDto.class);

        Ride ride = rideService.createNewRide(middleRideRequestDto,currentDriver);
        return modelMapper
                .map(ride, RideDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RideDto endRideAbruptly(Long rideId) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllRides() {
        return List.of();
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(()-> new RuntimeException("No driver resource found"));
    }
}
