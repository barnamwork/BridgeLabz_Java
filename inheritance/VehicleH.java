package inheritance;

public class VehicleH {
    int maxSpeed;
    String model;

    VehicleH(int maxSpeed, String model){
        this.maxSpeed=maxSpeed;
        this.model=model;
    }
    void displayInfo(){
        System.out.println("maxSpeed : " + maxSpeed + "kms/hr");
        System.out.println("model : " + model);
    }

    static void main() {
        ElectricVehicle ev = new ElectricVehicle(100, "Tesla");
        PetrolVehicle car = new PetrolVehicle(200, "BMW" );

        ev.displayInfo();
        System.out.println();
        car.displayInfo();
        System.out.println();

        ev.charge();
        System.out.println();
        car.refuel();
    }
}
interface Refuelable{
    void refuel();
}
class ElectricVehicle extends VehicleH{

    ElectricVehicle(int maxSpeed, String model){
        super(maxSpeed, model);
    }

    void charge(){
        System.out.println("Now the Electric vehicle is charging");
    }
    void displayInfo(){
        super.displayInfo();
    }
}
class PetrolVehicle extends VehicleH implements Refuelable{

    PetrolVehicle(int maxSpeed, String model ){
        super(maxSpeed, model);
    }

    public void refuel(){
        System.out.println("Now the Petrol vehicle is refueling");
    }

    void displayInfo(){
        super.displayInfo();
    }
}
