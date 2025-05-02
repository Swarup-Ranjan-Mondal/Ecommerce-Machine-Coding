package service;

import model.*;
import repository.*;

public class BuyerService {
    BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public void addBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    public Buyer getBuyer(String buyerId) {
        return buyerRepository.get(buyerId);
    }
}
