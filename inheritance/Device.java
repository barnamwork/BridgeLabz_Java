package inheritance;

public class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status){
        this.deviceId=deviceId;
        this.status=status;
    }

    void displayStatus(){
        System.out.println("The device id is " + deviceId);
        System.out.println("The device status is " + status);
    }

    static void main() {
       Device device = new Device("Electronics", "Excellent");
       Thermostat thermometer = new Thermostat("Medical", "Good", 35);
       device.displayStatus();
        System.out.println(); thermometer.displayStatus();
    }
}
class Thermostat extends Device{
    int temperatureSetting;
    Thermostat(String deviceId, String status, int temperatureSetting){
        super(deviceId, status);
        this.temperatureSetting= temperatureSetting;
    }

    @Override
    void displayStatus(){
        super.displayStatus();
        System.out.println("The temperarture of the thermostat is " + temperatureSetting);
    }
}
