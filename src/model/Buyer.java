package model;

import utils.Utils;

public class Buyer {
    private final String buyerId;
    private final String name;
    private final Address address;

    public Buyer(String name, Address address) {
        this.buyerId = Utils.generateId();
        this.name = name;
        this.address = address;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getName() {
        return name;
    }

    public String getPinCode() {
        return address.getPincode();
    }
}
