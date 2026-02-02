import java.util.*;

/*
 * Calculates factorial of a number using recursion.
 */
public class FactorialCalculator {

    // Computes factorial recursively
    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
    }
}
