package level3;

import java.util.Scanner;

public class CollinearPoints {

    // b. Method to check collinearity using slope formula
    public static boolean isCollinearUsingSlope(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return (slopeAB == slopeBC) && (slopeBC == slopeAC);
    }

    // c. Method to check collinearity using area of triangle
    public static boolean isCollinearUsingArea(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        double area = 0.5 * (
                x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2)
        );

        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Input 3 points
        System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.print("Enter x3 y3: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        // Check using slope method
        System.out.println(
                "Collinear using Slope Method: " +
                        isCollinearUsingSlope(x1, y1, x2, y2, x3, y3)
        );

        // Check using area method
        System.out.println(
                "Collinear using Area Method: " +
                        isCollinearUsingArea(x1, y1, x2, y2, x3, y3)
        );

        sc.close();
    }
}
