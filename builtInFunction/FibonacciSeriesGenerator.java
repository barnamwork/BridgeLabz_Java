import java.util.*;

/*
 * Generates and prints the Fibonacci sequence up to n terms.
 */
public class FibonacciSeriesGenerator {

    // Prints Fibonacci series
    static void fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fibonacci(sc.nextInt());
    }
}
