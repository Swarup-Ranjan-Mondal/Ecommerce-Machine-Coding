package service;

import model.*;

import java.util.*;

public class OrderService {
    Map<String, Order> orders = new HashMap<>();
    ProductService productService;
    BuyerService buyerService;
    PincodeService pincodeService;

    public OrderService(ProductService ps, BuyerService bs, PincodeService pcs) {
        this.productService = ps;
        this.buyerService = bs;
        this.pincodeService = pcs;
    }

    public String placeOrder(Order order) {
        Buyer buyer = buyerService.getBuyer(order.getBuyerId());
        if (buyer == null) {
            return "Buyer not found";
        }

        Product product = productService.getProduct(order.getProductId());
        if (!pincodeService.isServiceable(product.getPinCode(), buyer.getPinCode(), order.getPaymentType())) {
            return "PinCode not serviceable for " + order.getPaymentType();
        }

        if (!productService.reduceInventory(order.getProductId(), order.getQuantity())) {
            return "Insufficient Inventory";
        }

        orders.put(order.getOrderId(), order);
        return "Order placed successfully!";
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }
}
