package com.dev.sayan.ridehailing.ridehailingmonolith.entities;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.TransactionMethod;
import com.dev.sayan.ridehailing.ridehailingmonolith.entities.enums.TransactionType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "app_wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private Double balance;

    @OneToMany(mappedBy = "wallet")
    private List<WalletTransaction> walletTransactions;


}
