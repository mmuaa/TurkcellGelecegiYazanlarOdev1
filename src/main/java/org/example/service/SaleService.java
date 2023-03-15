package org.example.service;

import org.example.model.Campaign;
import org.example.model.Sale;

public interface SaleService {
    void sellGame(Sale sale, Campaign campaign);
}
