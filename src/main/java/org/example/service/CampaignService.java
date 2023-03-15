package org.example.service;

import org.example.model.Campaign;

import java.util.List;

public interface CampaignService {
    Campaign getCampaignById(int id);
    Campaign addCampaign (Campaign campaign);
    Campaign updateCampaignById(int id,Campaign campaign);
    boolean deleteCampaignById(int id);
    List<Campaign> getCampaign();
}
