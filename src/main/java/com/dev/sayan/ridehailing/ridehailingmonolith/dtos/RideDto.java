package com.dev.sayan.ridehailing.ridehailingmonolith.dtos;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Driver;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Rider;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.PaymentMethod;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {
    private Long id;
    private Point pickUpLocation;
    private Point dropOffLocation;
    private LocalDateTime creationTime;
    private PaymentMethod paymentMethod;
    private RiderDto rider;
    private DriverDto driver;
    private RideStatus rideStatus;
    private Double fare;
    private LocalDateTime startRideTime;
    private LocalDateTime endRideTime;
}
