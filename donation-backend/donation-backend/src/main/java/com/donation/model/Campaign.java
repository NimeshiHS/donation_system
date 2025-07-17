package com.donation.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Campaign")  
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campaign_id;
    private String title;
    private String description;
    private Double goal_amount;
    private LocalDate start_date;
    private LocalDate end_date;

    // --- Getters and Setters ---
    public int getId() {
        return campaign_id;
    }

    public void setId(int id) {
        this.campaign_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGoalAmount() {
        return goal_amount;
    }

    public void setGoalAmount(Double goalAmount) {
        this.goal_amount = goalAmount;
    }

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate startDate) {
        this.start_date = startDate;
    }

    public LocalDate getEndDate() {
        return end_date;
    }

    public void setEndDate(LocalDate endDate) {
        this.end_date = endDate;
    }
}
