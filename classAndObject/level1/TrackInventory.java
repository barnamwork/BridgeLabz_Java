package level1;

// This class manages item details and calculates total cost based on quantity

class TrackInventory {

    int itemCode;
    String itemName;
    double price;

    void displayAndTotal(int quantity) {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + (price * quantity));
    }

    public static void main(String[] args) {
        TrackInventory item = new TrackInventory();

        item.itemCode = 11;
        item.itemName = "Pen";
        item.price = 10;

        item.displayAndTotal(5);
    }
}


