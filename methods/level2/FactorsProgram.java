package level2;

import java.util.Scanner;

public class FactorsProgram {

    public static int[] findFactors(int n) {
        int count = 0;

        // first loop to count factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;

        // second loop to store factors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                factors[index++] = i;
        }

        return factors;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors)
            sum += f;
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors)
            product *= f;
        return product;
    }

    public static double sumOfSquares(int[] factors) {
        double sum = 0;
        for (int f : factors)
            sum += Math.pow(f, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] factors = findFactors(n);

        System.out.println("Factors:");
        for (int f : factors)
            System.out.print(f + " ");

        System.out.println("\nSum = " + sumOfFactors(factors));
        System.out.println("Product = " + productOfFactors(factors));
        System.out.println("Sum of Squares = " + sumOfSquares(factors));
    }
}
