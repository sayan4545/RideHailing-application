package com.dev.sayan.ridehailing.ridehailingmonolith.entities;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.PaymentMethod;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Double amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Ride ride;

    @CreationTimestamp
    private LocalDateTime paymentTime;
}
