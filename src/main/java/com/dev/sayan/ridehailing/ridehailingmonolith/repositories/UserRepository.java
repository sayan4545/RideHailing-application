package com.dev.sayan.ridehailing.ridehailingmonolith.repositories;

import com.dev.sayan.ridehailing.ridehailingmonolith.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
