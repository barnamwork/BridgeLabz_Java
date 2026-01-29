package level1;

// This class stores mobile phone details and displays full phone information

class DisplayMobileDetails {

    String brand;
    String model;
    double price;

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        DisplayMobileDetails m = new DisplayMobileDetails();

        m.brand = "Samsung";
        m.model = "S21";
        m.price = 55000;

        m.display();
    }
}


