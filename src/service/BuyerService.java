package service;

import model.*;
import java.util.*;

public class BuyerService {
    Map<String, Buyer> buyers = new HashMap<>();

    public void addBuyer(Buyer buyer) {
        buyers.put(buyer.getBuyerId(), buyer);
    }

    public Buyer getBuyer(String buyerId) {
        return buyers.get(buyerId);
    }
}
