package com.donation.repository;

import com.donation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Custom query method
    User findByEmail(String email);
}
