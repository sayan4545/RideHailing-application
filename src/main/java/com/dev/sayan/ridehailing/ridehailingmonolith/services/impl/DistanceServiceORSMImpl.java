package com.dev.sayan.ridehailing.ridehailingmonolith.services.impl;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.ORSMResponseDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class DistanceServiceORSMImpl implements DistanceService {
    private static final String ORSM_API = "https://router.project-osrm.org/route/v1/driving/";

    //    @Override
//    public Double calculateDistance(Point src, Point dest) {
//
//
//        // call the third party api
//        try{
//            String uri = src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY() + "?overview=false&geometries=geojson";
//            ORSMResponseDto responseDto =
//                    RestClient.builder()
//                            .baseUrl(ORSM_API)
//                            .build()
//                            .get()
//                            .uri(uri)
//                            .retrieve()
//                            .body(ORSMResponseDto.class);
//
//            //if(responseDto == null) throw new RuntimeException("Error in calculating the distance");
//            if (responseDto == null || responseDto.getRoutes() == null || responseDto.getRoutes().isEmpty()) {
//                throw new RuntimeException("No routes available from OSRM");
//            }
//            System.out.println("Calling OSRM: " + ORSM_API + uri);
//
//            return responseDto.getRoutes().get(0).getDistance()/1000.0;
//
//
//        } catch (Exception e) {
//            throw new RuntimeException("No routes availbale "+ e.getMessage());
//        }
//    @Override
//    public Double calculateDistance(Point src, Point dest) {
//        try {
//            // Ensure src.getX() is Longitude and src.getY() is Latitude.
//            String uri = src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY() + "?overview=false&geometries=geojson";
//
//            System.out.println("Calling OSRM: " + ORSM_API + uri);
//
//            ORSMResponseDto responseDto = RestClient.builder()
//                    .baseUrl(ORSM_API)
//                    // CRITICAL: OSRM public API blocks requests without a valid User-Agent
//                    .defaultHeader("User-Agent", "RideHailingMonolith/1.0 (dev@sayan.com)")
//                    .build()
//                    .get()
//                    .uri(uri)
//                    .retrieve()
//                    // Handle genuine OSRM errors (like NoRoute) gracefully before Jackson tries to parse them
//                    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
//                        String errorBody = new String(response.getBody().readAllBytes());
//                        throw new RuntimeException("OSRM Client Error: " + errorBody);
//                    })
//                    .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
//                        throw new RuntimeException("OSRM Server Error - Service Unavailable");
//                    })
//                    .body(ORSMResponseDto.class);
//
//            if (responseDto == null || responseDto.getRoutes() == null || responseDto.getRoutes().isEmpty()) {
//                throw new RuntimeException("No routes available from OSRM");
//            }
//
//            return responseDto.getRoutes().get(0).getDistance() / 1000.0;
//
//        } catch (Exception e) {
//            // Using a distinct error prefix helps isolate parsing/connection issues from business logic
//            throw new RuntimeException("Distance calculation failed: " + e.getMessage(), e);
//        }
//
    @Override
    public Double calculateDistance(Point src, Point dest) {
        try {
            String uri = src.getX() + "," + src.getY() + ";" + dest.getX() + "," + dest.getY() + "?overview=false&geometries=geojson";
            System.out.println("Calling OSRM: " + ORSM_API + uri);

            // Use toEntity() to capture the entire HTTP response safely
            var responseEntity = RestClient.builder()
                    .baseUrl(ORSM_API)
                    .defaultHeader("User-Agent", "RideHailingMonolith/1.0 (dev@sayan.com)")
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    // Don't throw exceptions on 4xx/5xx yet, just wrap them in the entity
                    .onStatus(status -> status.isError(), (req, res) -> {})
                    .toEntity(String.class);

            System.out.println("====== OSRM HTTP RESPONSE ======");
            System.out.println("STATUS CODE: " + responseEntity.getStatusCode());
            System.out.println("HEADERS: " + responseEntity.getHeaders());
            System.out.println("BODY: " + responseEntity.getBody());
            System.out.println("================================");

            throw new RuntimeException("Check the IDE console for the HTTP RESPONSE.");

        } catch (Exception e) {
            throw new RuntimeException("Distance calculation failed: " + e.getMessage(), e);
        }
    }

}


