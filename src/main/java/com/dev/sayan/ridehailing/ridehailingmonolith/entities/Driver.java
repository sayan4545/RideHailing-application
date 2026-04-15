package com.dev.sayan.ridehailing.ridehailingmonolith.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "app_driver")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;

    @OneToOne(cascade =CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    private Boolean isAvailable;
    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point currentLocation;
}
