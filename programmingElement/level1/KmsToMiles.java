package level1;
import java.util.Scanner;
public class KmsToMiles {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        double km;
        km = input.nextInt();
        double miles=1.6;
        double distance=km/miles;
        System.out.println("The total miles is "+ distance + " mile for the given " + km + " km");
        input.close();

    }
}
