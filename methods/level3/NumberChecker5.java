package level3;

import java.util.Scanner;

public class NumberChecker5 {

    // 1. Find factors and return array
    public static int[] findFactors(int num) {
        int count = 0;

        // first loop to count factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;

        // second loop to store factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                factors[index++] = i;
        }

        return factors;
    }

    // 2. Greatest factor
    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) {
            if (f > max)
                max = f;
        }
        return max;
    }

    // 3. Sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors)
            sum += f;
        return sum;
    }

    // 4. Product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors)
            product *= f;
        return product;
    }

    // 5. Product of cube of factors
    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int f : factors)
            product *= Math.pow(f, 3);
        return product;
    }

    // helper method: sum of proper divisors
    public static int sumOfProperDivisors(int num, int[] factors) {
        int sum = 0;
        for (int f : factors) {
            if (f != num)
                sum += f;
        }
        return sum;
    }

    // 6. Perfect number check
    public static boolean isPerfect(int num, int[] factors) {
        return sumOfProperDivisors(num, factors) == num;
    }

    // 7. Abundant number check
    public static boolean isAbundant(int num, int[] factors) {
        return sumOfProperDivisors(num, factors) > num;
    }

    // 8. Deficient number check
    public static boolean isDeficient(int num, int[] factors) {
        return sumOfProperDivisors(num, factors) < num;
    }

    // factorial helper
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }

    // 9. Strong number check
    public static boolean isStrong(int num) {
        int temp = num;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);

        System.out.print("Factors: ");
        for (int f : factors)
            System.out.print(f + " ");

        System.out.println("\nGreatest Factor = " + greatestFactor(factors));
        System.out.println("Sum of Factors = " + sumOfFactors(factors));
        System.out.println("Product of Factors = " + productOfFactors(factors));
        System.out.println("Product of Cube of Factors = " + productOfCubeOfFactors(factors));

        System.out.println("Perfect Number: " + isPerfect(num, factors));
        System.out.println("Abundant Number: " + isAbundant(num, factors));
        System.out.println("Deficient Number: " + isDeficient(num, factors));
        System.out.println("Strong Number: " + isStrong(num));

        sc.close();
    }
}
