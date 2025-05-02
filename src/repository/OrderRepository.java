package repository;

import java.util.*;

import model.*;

public class OrderRepository {
    private final HashMap<String, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Order get(String orderId) {
        return orders.get(orderId);
    }

    public Collection<Order> getAll() {
        return orders.values();
    }
}
