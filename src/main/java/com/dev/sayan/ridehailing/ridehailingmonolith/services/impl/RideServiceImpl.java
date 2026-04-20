package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideRequestDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Driver;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Ride;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.RideRequestStatus;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.RideStatus;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.RideRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.RideRequestRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RideRequestService;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RideService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RideServiceImpl implements RideService {
    private final ModelMapper modelMapper;
    private final RideRepository rideRepository;
    private final RideRequestRepository rideRequestRepository;
    private final RideRequestService rideRequestService;

    public RideServiceImpl(ModelMapper modelMapper, RideRepository rideRepository, RideRequestRepository rideRequestRepository, RideRequestService rideRequestService) {
        this.modelMapper = modelMapper;
        this.rideRepository = rideRepository;
        this.rideRequestRepository = rideRequestRepository;
        this.rideRequestService = rideRequestService;
    }

    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void matchDriverWithRider(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        rideRequestDto.setRideRequestStatus(RideRequestStatus.ACCEPTED);
        RideDto currentRideDto = modelMapper
                .map(rideRequestDto, RideDto.class);
        currentRideDto.setRideStatus(RideStatus.ACCEPTED);
        currentRideDto.setDriver(modelMapper.map(driver, DriverDto.class));
        currentRideDto.setOtp(generateRandomOtp());
        currentRideDto.setId(null);
        Ride currentRide = modelMapper.map(currentRideDto,Ride.class);
        RideRequest toUpdateOrSave = modelMapper
                .map(rideRequestDto,RideRequest.class);
        rideRequestService.update(toUpdateOrSave);
        return rideRepository.save(currentRide);


    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRides(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }

    private String generateRandomOtp(){
        Random random = new Random();
        int OtpInt = random.nextInt(10000);
        return String.format("%04d",OtpInt);
    }
}
