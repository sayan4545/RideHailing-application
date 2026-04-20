package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.ORSMResponseDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.DistanceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceORSMImpl implements DistanceService {
    private static final String ORSM_API = "https://router.project-osrm.org/route/v1/driving/";
    @Override
    public Double calculateDistance(Point src, Point dest) {
        try {
            String uri = src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY()+"?overview=false";
            System.out.println("Calling OSRM: " + ORSM_API + uri);
            return RestClient.builder()
                    .baseUrl(ORSM_API)
                    .defaultHeader("User-Agent", "RideHailingMonolith/1.0 (dev@sayan.com)")
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(ORSMResponseDto.class)
                    .getRoutes()
                    .stream()
                    .findFirst()
                    .map(route-> route.getDistance() /1000.0)
                    .orElseThrow(()-> new RuntimeException("No routes found"));

//            if (responseDto == null) {
//                throw new RuntimeException("Null response from OSRM");
//            }
//            if (!"Ok".equals(responseDto.getCode())) {
//                throw new RuntimeException("OSRM error: " + responseDto.getCode()
//                        + " - " + responseDto.getMessage());
//            }
//            if (responseDto.getRoutes() == null || responseDto.getRoutes().isEmpty()) {
//                throw new RuntimeException("No routes in OSRM response");
//            }
//            return responseDto.getRoutes().get(0).getDistance() / 1000.0;
        } catch (Exception e) {
            throw new RuntimeException("Distance calculation failed: " + e.getMessage(), e);
        }
    }

}



