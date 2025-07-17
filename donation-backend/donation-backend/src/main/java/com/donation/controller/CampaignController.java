package com.donation.controller;
import com.donation.model.Campaign;
import com.donation.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Allow frontend access
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;

    @PostMapping("/campaigns")
    
    public String createCampaign(
        @RequestParam String title,
        @RequestParam String description,
        @RequestParam Double goal_amount,
        @RequestParam String start_date,
        @RequestParam String end_date
    ) {
        Campaign campaign = new Campaign();
        campaign.setTitle(title);
        campaign.setDescription(description);
        campaign.setGoalAmount(goal_amount);
        campaign.setStartDate(LocalDate.parse(start_date));
        campaign.setEndDate(LocalDate.parse(end_date));

        campaignRepository.save(campaign);
        return "redirect:/";
    }
    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}

