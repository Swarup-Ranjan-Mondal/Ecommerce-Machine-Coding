package model;

import utils.Utils;

public class Product {
    private final String productId;
    private final String name;
    private final Address address;
    private int quantity;

    public Product(String name, int quantity, Address address) {
        this.productId = Utils.generateId();
        this.name = name;
        this.quantity = quantity;
        this.address = address;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPinCode() {
        return address.getPincode();
    }
}
