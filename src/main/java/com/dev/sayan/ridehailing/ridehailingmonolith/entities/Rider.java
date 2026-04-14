package com.dev.sayan.ridehailing.ridehailingmonolith.entities;

import jakarta.persistence.*;
import org.springframework.web.cors.PreFlightRequestHandler;

@Entity
@Table(name = "app_rider")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
