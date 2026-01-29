package level3;

import java.util.Scanner;

public class NumberChecker4 {

    // 1. Prime number check
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // 2. Neon number check
    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    // 3. Spy number check
    public static boolean isSpy(int num) {
        int sum = 0;
        int product = 1;

        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }
        return sum == product;
    }

    // 4. Automorphic number check
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        int temp = num;

        while (temp > 0) {
            if (square % 10 != temp % 10)
                return false;

            square /= 10;
            temp /= 10;
        }
        return true;
    }

    // 5. Buzz number check
    public static boolean isBuzz(int num) {
        return (num % 7 == 0) || (num % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        System.out.println("Prime Number: " + isPrime(num));
        System.out.println("Neon Number: " + isNeon(num));
        System.out.println("Spy Number: " + isSpy(num));
        System.out.println("Automorphic Number: " + isAutomorphic(num));
        System.out.println("Buzz Number: " + isBuzz(num));

        sc.close();
    }
}
