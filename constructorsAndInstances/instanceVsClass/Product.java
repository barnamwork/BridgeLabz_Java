package instancevsclass;

import java.util.Scanner;

class Product {

    String productName;
    double price;
    static int totalProducts = 0;

    Product(String name, double price) {
        this.productName = name;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println(productName + " - " + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Product name: ");
        String n = sc.nextLine();
        System.out.print("Price: ");
        double p = sc.nextDouble();

        Product prod = new Product(n, p);
        prod.displayProductDetails();
        Product.displayTotalProducts();
    }
}

