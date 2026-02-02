import java.util.*;

/*
 * Calculates the GCD and LCM of two numbers.
 */
public class GCDAndLCMCalculator {

    // Computes GCD using Euclidean algorithm
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Computes LCM using GCD
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(gcd(x, y));
        System.out.println(lcm(x, y));
    }
}
