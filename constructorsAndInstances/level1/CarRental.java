package Level1;

import java.util.Scanner;

// Car rental system with cost calculation using Scanner

class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private double pricePerDay = 1000;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateCost() {
        return rentalDays * pricePerDay;
    }

    void display() {
        System.out.println(customerName + " | " + carModel + " | Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateCost());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Customer Name: ");
        String c = sc.nextLine();
        System.out.print("Car Model: ");
        String m = sc.nextLine();
        System.out.print("Rental Days: ");
        int d = sc.nextInt();

        CarRental r = new CarRental(c, m, d);
        r.display();
    }
}
