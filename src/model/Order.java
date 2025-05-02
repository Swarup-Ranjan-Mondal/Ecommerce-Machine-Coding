package model;

import utils.Utils;

public class Order {
    private final String orderId;
    private final String buyerId;
    private final String productId;
    private int quantity;
    private final PaymentType paymentType;

    public Order(String buyerId, String productId, int quantity, PaymentType paymentType) {
        this.orderId = Utils.generateId();
        this.buyerId = buyerId;
        this.productId = productId;
        this.quantity = quantity;
        this.paymentType = paymentType;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
