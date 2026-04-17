package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceORSMImpl implements DistanceService {
    @Override
    public Double calculateDistance(Point src, Point dest) {
        // call the third party api
        return 0.0;
    }
}
