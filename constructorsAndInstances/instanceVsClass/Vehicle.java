package instancevsclass;

import java.util.Scanner;

class Vehicle {

    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable
    static double registrationFee = 5000;

    Vehicle(String owner, String type) {
        this.ownerName = owner;
        this.vehicleType = type;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Owner name: ");
        String o = sc.nextLine();
        System.out.print("Vehicle type: ");
        String v = sc.nextLine();
        System.out.print("New registration fee: ");
        double fee = sc.nextDouble();

        Vehicle.updateRegistrationFee(fee);

        Vehicle ve = new Vehicle(o, v);
        ve.displayVehicleDetails();
    }
}

