package level2;

import java.util.Scanner;

public class PoundToKg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double pound = sc.nextDouble();

        double kg = pound / 2.2;

        System.out.println("The weight of the person in pound is "
                + pound + " and in kg is " + kg);
    }
}