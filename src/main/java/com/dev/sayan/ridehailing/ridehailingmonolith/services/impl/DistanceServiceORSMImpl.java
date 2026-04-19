package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.ORSMResponseDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class DistanceServiceORSMImpl implements DistanceService {
    private static final String ORSM_API = "http://router.project-osrm.org/route/v1/driving/";
    @Override
    public Double calculateDistance(Point src, Point dest) {
        // call the third party api
        try{
            String uri = src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY();
            ORSMResponseDto responseDto =
                    RestClient.builder()
                            .baseUrl(ORSM_API)
                            .build()
                            .get()
                            .uri(uri)
                            .retrieve()
                            .body(ORSMResponseDto.class);
            return responseDto.getRoutes().get(0).getDistance()/1000.0;
        } catch (Exception e) {
            throw new RuntimeException("No routes availbale"+ e.getMessage());
        }

    }
}
