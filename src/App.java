import model.*;
import service.*;

public class App {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        BuyerService buyerService = new BuyerService();
        PincodeService pincodeService = new PincodeService();
        OrderService orderService = new OrderService(productService, buyerService, pincodeService);

        Address address1 = new Address("Tag", "Vizag", "531162");
        Address address2 = new Address("Somaji", "Hyderabad", "500082");
        Address address3 = new Address("Hubili", "Bangalore", "536264");

        Product product1 = new Product("T-shirt Levis", 10, address1);
        Product product2 = new Product("Casual Shoes", 10, address2);
        Product product3 = new Product("Modern Classical Pants", 10, address3);
        Product product4 = new Product("Kurta", 10, address1);

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);

        pincodeService.addServiceability("531162", "500082", PaymentType.PREPAID);
        pincodeService.addServiceability("531162", "531162", PaymentType.PREPAID);
        pincodeService.addServiceability("500082", "536264", PaymentType.PREPAID);
        pincodeService.addServiceability("536264", "531162", PaymentType.PREPAID);

        Buyer buyer1 = new Buyer("LavKumar", address1);
        Buyer buyer2 = new Buyer("Pranvya", address2);
        Buyer buyer3 = new Buyer("Khavya", address3);

        buyerService.addBuyer(buyer1);
        buyerService.addBuyer(buyer2);
        buyerService.addBuyer(buyer3);

        Order order1 = new Order(buyer1.getBuyerId(), product1.getProductId(), 5, PaymentType.PREPAID);
        Order order2 = new Order(buyer3.getBuyerId(), product1.getProductId(), 5, PaymentType.PREPAID);
        Order order3 = new Order(buyer1.getBuyerId(), product1.getProductId(), 6, PaymentType.PREPAID);

        String result1 = orderService.placeOrder(order1);
        System.out.println(result1);

        String result2 = orderService.placeOrder(order2);
        System.out.println(result2);

        String result3 = orderService.placeOrder(order3);
        System.out.println(result3);

        System.out.println("Inventory of " + product1.getName() + " is " + productService.checkInventory(product1.getProductId()));
    }
}
