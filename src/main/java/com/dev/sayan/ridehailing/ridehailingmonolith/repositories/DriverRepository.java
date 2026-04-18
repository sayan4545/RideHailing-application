package com.dev.sayan.ridehailing.ridehailingmonolith.repositories;

import com.dev.sayan.ridehailing.ridehailingmonolith.dtos.DriverDto;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    @Query(value = """
        SELECT d.*, 
        ST_Distance(d.current_location, :pickupLocation) AS distance
        FROM drivers d
        WHERE d.is_available = true
        AND ST_DWithin(d.current_location, :pickupLocation, 1000)
        ORDER BY distance
        LIMIT 10
    """, nativeQuery = true)
    List<DriverDto> findTenNearestdrivers(Point pickUpLocation);

    @Query(value = """
        SELECT d.*, 
        ST_Distance(d.current_location, :pickupLocation) AS distance
        FROM drivers d
        WHERE d.is_available = true
        AND ST_DWithin(d.current_location, :pickupLocation, 1000)
        ORDER BY distance ASC, d.rating DESC
        LIMIT 10
    """, nativeQuery = true)
    List<DriverDto> findTenHighestRatedDrivers(Point pickUpLocation);
}
