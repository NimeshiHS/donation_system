package com.donation.repository;

import com.donation.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}

