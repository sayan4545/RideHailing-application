package com.dev.sayan.ridehailing.ridehailingmonolith.entities;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.TransactionMethod;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_walletTrasnsaction")
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionMethod transactionMethod;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id",referencedColumnName = "id")
    private Ride ride;

    private String transactionId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // One wallet can have many transactions
    @ManyToOne
    private Wallet wallet;
}
