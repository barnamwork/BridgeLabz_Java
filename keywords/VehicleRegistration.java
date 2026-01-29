package keywords;

/**
 * The Vehicle class represents a vehicle with static registration fee, private owner and type, and final registration number.
 * It demonstrates static, private, final keywords, and instanceof operator.
 */
class Vehicle{
    public static int registrationFees = 2000;

    private String ownerName, vehicleType;
    private final String registrationNumber;

    Vehicle(String ownerName, String vehicleType, String registrationNumber){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: ₹" + registrationFees);
    }

    // Static method to update the registration fee
    public static void updateRegistrationFee(int newReg){
        registrationFees = newReg;
    }
}

/**
 * The VehicleRegistration class demonstrates vehicle registration using various Java keywords.
 */
public class VehicleRegistration {
    public static void main(String[] args){
        Vehicle v1 = new Vehicle("Aayush", "Car", "HR26D1234");

        Vehicle.updateRegistrationFee(6767);

        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        } else {
            System.out.println("Object is not a Vehicle.");
        }
    }
}