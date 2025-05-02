package repository;

import java.util.*;

import model.*;

public class BuyerRepository {
    private final HashMap<String, Buyer> buyers = new HashMap<>();

    public void save(Buyer buyer) {
        buyers.put(buyer.getBuyerId(), buyer);
    }

    public Buyer get(String buyerId) {
        return buyers.get(buyerId);
    }
}
