package level2;

// This class simulates a shopping cart using constructor, add/remove and total cost system

class ShoppingCart {

    String itemName;
    double price;
    int quantity;

    // Parameterized Constructor
    ShoppingCart(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(String name, double p, int q) {
        itemName = name;
        price = p;
        quantity = q;
    }

    void removeItem() {
        itemName = null;
        price = 0;
        quantity = 0;
    }

    void displayTotal() {
        System.out.println("Item: " + itemName);
        System.out.println("Total Cost: " + (price * quantity));
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart("Shoes", 2000, 2);
        cart.displayTotal();

        cart.removeItem();
    }
}

