package com.dev.sayan.ridehailing.ridehailingmonolith.services;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;

public interface RideRequestService {

    RideRequest getRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
