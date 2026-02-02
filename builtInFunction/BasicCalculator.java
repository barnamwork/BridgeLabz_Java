import java.util.*;

/*
 * Performs basic arithmetic operations on two numbers.
 */
public class BasicCalculator {

    // Adds two numbers
    static int add(int a, int b) {
        return a + b;
    }

    // Subtracts two numbers
    static int subtract(int a, int b) {
        return a - b;
    }

    // Multiplies two numbers
    static int multiply(int a, int b) {
        return a * b;
    }

    // Divides two numbers
    static int divide(int a, int b) {
        return a / b;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ch = sc.nextInt();
        if (ch == 1) System.out.println(add(x, y));
        if (ch == 2) System.out.println(subtract(x, y));
        if (ch == 3) System.out.println(multiply(x, y));
        if (ch == 4) System.out.println(divide(x, y));
    }
}
