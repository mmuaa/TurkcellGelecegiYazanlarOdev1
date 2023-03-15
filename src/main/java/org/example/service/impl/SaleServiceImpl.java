package org.example.service.impl;

import org.example.model.Campaign;
import org.example.model.Game;
import org.example.model.Sale;
import org.example.service.Logger;
import org.example.service.SaleService;
import org.example.util.EDevletSystem;

import java.util.List;

public class SaleServiceImpl implements SaleService {

    private List<Logger> loggers;

    public SaleServiceImpl(List<Logger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void sellGame(Sale sale, Campaign campaign) {
        if(EDevletSystem.verifyPlayer(sale.getPlayer())){
            //double totalPrice = sale.getGames().stream().map(game -> game.getPrice()).reduce(0.0,Double::sum);
            double totalPrice = 0;
            for (Game game:sale.getGames()) {
                totalPrice += game.getPrice();
            }
            double totalPriceAfterDiscount = totalPrice * (100- campaign.getDiscount())/100;
            String message = sale.getPlayer().getFirstName()+" isimli kullanıcı "+campaign.getName()+" " +
                    "kampanyası ile "+totalPriceAfterDiscount+" Tl ödeyip oyunları satın aldı.";
            for (Logger logger : loggers){
                logger.log(message);
            }
        }else{
            System.out.println("Kullanıcı doğrulanamadı.");
        }
    }
}
