package com.dev.sayan.ridehailing.ridehailingmonolith.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.cors.PreFlightRequestHandler;

@Entity
@Table(name = "app_rider")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double rating;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
