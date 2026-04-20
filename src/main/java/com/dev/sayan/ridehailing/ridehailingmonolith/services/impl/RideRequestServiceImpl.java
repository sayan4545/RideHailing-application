package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.RideRequest;
import com.dev.sayan.ridehailing.ridehailingmonolith.repositories.RideRequestRepository;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.RideRequestService;
import org.springframework.stereotype.Service;

@Service
public class RideRequestServiceImpl implements RideRequestService {
    private final RideRequestRepository rideRequestRepository;

    public RideRequestServiceImpl(RideRequestRepository rideRequestRepository) {
        this.rideRequestRepository = rideRequestRepository;
    }

    @Override
    public RideRequest getRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(()-> new RuntimeException("No ride request with the id"));
    }

    @Override
    public void update(RideRequest rideRequest) {
        RideRequest toSave = rideRequestRepository
                .findById(rideRequest.getId())
                .orElseThrow(()-> new RuntimeException("No ride request with the id"));
        rideRequestRepository.save(rideRequest);
    }
}
