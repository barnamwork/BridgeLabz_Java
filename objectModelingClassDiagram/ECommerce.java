package objectModelingClassDiagram;

/*
 * ECommerce
 * -------------
 * Demonstrates:
 * 1. Association between Customer and Order
 * 2. Aggregation between Order and Product
 */

import java.util.ArrayList;

/* Product class */
class Product {

    // Product name
    private String name;

    // Constructor to initialize product
    public Product(String name) {
        this.name = name;
    }

    // Returns product name
    public String getName() {
        return name;
    }
}

/* Order class (Aggregation with Product) */
class Order {

    // List of products in order
    private ArrayList<Product> products = new ArrayList<>();

    // Adds product to order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Displays products in order
    public void showProducts() {
        System.out.println("Products in order:");
        for (Product p : products) {
            System.out.println(p.getName());
        }
    }
}

/* Customer class */
class Customer {

    // Customer name
    private String name;

    // Constructor to initialize customer
    public Customer(String name) {
        this.name = name;
    }

    // Places an order
    public void placeOrder(Order order) {
        System.out.println(name + " placed an order.");
        order.showProducts();
    }
}

/* Main class */
public class ECommerce {

    public static void main(String[] args) {

        Customer customer = new Customer("Aman");

        Product p1 = new Product("Laptop");
        Product p2 = new Product("Mouse");

        Order order = new Order();
        order.addProduct(p1);
        order.addProduct(p2);

        customer.placeOrder(order);
    }
}
