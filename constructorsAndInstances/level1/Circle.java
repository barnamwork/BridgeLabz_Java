package Level1;

import java.util.Scanner;

// Circle class using constructor chaining with Scanner

class Circle {

    private double radius;

    Circle() {
        this(1.0);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + Math.PI * radius * radius);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        Circle c = new Circle(r);
        c.display();
    }
}
