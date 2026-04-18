package com.dev.sayan.ridehailing.ridehailingmonolith.repositories;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
