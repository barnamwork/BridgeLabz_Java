import java.util.*;

/*
 * Converts temperature between Fahrenheit and Celsius.
 */
public class TemperatureConverter {

    // Converts Fahrenheit to Celsius
    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Converts Celsius to Fahrenheit
    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        int choice = sc.nextInt();
        if (choice == 1) System.out.println(fahrenheitToCelsius(temp));
        else System.out.println(celsiusToFahrenheit(temp));
    }
}
