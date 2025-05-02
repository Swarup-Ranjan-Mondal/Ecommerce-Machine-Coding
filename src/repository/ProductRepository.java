package repository;

import java.util.*;

import model.Product;

public class ProductRepository {
    private final HashMap<String, Product> products = new HashMap<>();

    public void save(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product get(String productId) {
        return products.get(productId);
    }

    public Collection<Product> getAll() {
        return products.values();
    }
}
