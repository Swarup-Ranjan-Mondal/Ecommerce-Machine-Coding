package service;

import model.Product;
import java.util.*;

public class ProductService {
    Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public void updateProduct(String productId, int quantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
        }
    }

    public int checkInventory(String productId) {
        Product product = products.get(productId);
        if(product != null) {
            return product.getQuantity();
        }
        return 0;
    }

    public boolean reduceInventory(String productId, int qty) {
        synchronized (this) {
            Product product = products.get(productId);
            if (product != null && product.getQuantity() >= qty) {
                product.setQuantity(product.getQuantity() - qty);
                return true;
            }
            return false;
        }
    }
}
