package com.dev.sayan.ridehailing.ridehailingmonolith.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "app_driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;

    @OneToOne(cascade =CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
