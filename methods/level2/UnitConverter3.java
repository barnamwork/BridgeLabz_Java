package level2;

import java.util.Scanner;

public class UnitConverter3 {

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double poundsToKg(double pounds) {
        return pounds * 0.453592;
    }

    public static double kgToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double gallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double litersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("Celsius = " + fahrenheitToCelsius(f));

        System.out.print("Enter Celsius: ");
        double c = sc.nextDouble();
        System.out.println("Fahrenheit = " + celsiusToFahrenheit(c));

        System.out.print("Enter pounds: ");
        double pounds = sc.nextDouble();
        System.out.println("Kilograms = " + poundsToKg(pounds));

        System.out.print("Enter kilograms: ");
        double kg = sc.nextDouble();
        System.out.println("Pounds = " + kgToPounds(kg));

        System.out.print("Enter gallons: ");
        double gallons = sc.nextDouble();
        System.out.println("Liters = " + gallonsToLiters(gallons));

        System.out.print("Enter liters: ");
        double liters = sc.nextDouble();
        System.out.println("Gallons = " + litersToGallons(liters));

        sc.close();
    }
}

