package com.donation.repository;

import com.donation.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Integer> {
    
    // Custom query method
    user findByEmail(int user_id);
}
