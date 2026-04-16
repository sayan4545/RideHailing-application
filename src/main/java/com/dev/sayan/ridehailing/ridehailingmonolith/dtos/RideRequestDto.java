package com.dev.sayan.ridehailing.ridehailingmonolith.dtos;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Rider;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.PaymentMethod;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.RideRequestStatus;
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
public class RideRequestDto {

    private Long id;
    private PointDto pickUpLocation;
    private PointDto dropLocation;
    private LocalDateTime currentTime;
    private RiderDto rider;
    private PaymentMethod paymentMethod;
    private RideRequestStatus rideRequestStatus;
}
