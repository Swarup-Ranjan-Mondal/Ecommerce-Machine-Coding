package service;

import model.Product;
import repository.ProductRepository;

public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(String productId) {
        return productRepository.get(productId);
    }

    public void updateProduct(Product updatedProduct) {
        Product product = productRepository.get(updatedProduct.getProductId());
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        productRepository.save(product);
    }

    public int checkInventory(String productId) {
        Product product = productRepository.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return 0;
        }
        return product.getQuantity();
    }

    public boolean reduceInventory(String productId, int qty) {
        synchronized (this) {
            Product product = productRepository.get(productId);
            if (product != null && product.getQuantity() >= qty) {
                product.setQuantity(product.getQuantity() - qty);
                return true;
            }
            return false;
        }
    }
}
