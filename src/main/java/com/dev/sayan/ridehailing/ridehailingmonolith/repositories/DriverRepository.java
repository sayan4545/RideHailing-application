package com.dev.sayan.ridehailing.ridehailingmonolith.repositories;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
}
