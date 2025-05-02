package service;

import model.*;
import repository.*;

import java.util.*;

public class OrderService {
    OrderRepository orderRepository;

    ProductService productService;
    BuyerService buyerService;
    PinCodeService pinCodeService;

    public OrderService(OrderRepository orderRepository, ProductService productService, BuyerService buyerService, PinCodeService pincodeService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.buyerService = buyerService;
        this.pinCodeService = pincodeService;
    }

    public String placeOrder(Order order) {
        Buyer buyer = buyerService.getBuyer(order.getBuyerId());
        if (buyer == null) {
            return "Buyer not found";
        }

        Product product = productService.getProduct(order.getProductId());
        if (!pinCodeService.isServiceable(product.getPinCode(), buyer.getPinCode(), order.getPaymentType())) {
            return "PinCode not serviceable for " + order.getPaymentType();
        }

        if (!productService.reduceInventory(order.getProductId(), order.getQuantity())) {
            return "Insufficient Inventory";
        }

        orderRepository.save(order);
        return "Order placed successfully!";
    }

    public Order getOrder(String orderId) {
        return orderRepository.get(orderId);
    }
}
