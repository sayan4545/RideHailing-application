package com.dev.sayan.ridehailing.ridehailingmonolith.services;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RideDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.RiderDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Driver;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);
    RideDto cancelRide(Long rideId);
    RideDto startRide(Long rideId);
    RideDto endRide(Long rideId);
    RiderDto rateRider(Long rideId,Integer rating);
    RideDto endRideAbruptly(Long rideId);

    DriverDto getMyProfile();
    List<RideDto> getAllRides();

    Driver getCurrentDriver();
}
