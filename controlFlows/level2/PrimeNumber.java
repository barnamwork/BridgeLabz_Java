package level2;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        boolean isPrime = true;

        if (number <= 1)
            isPrime = false;
        else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime)
            System.out.println("Prime Number");
        else
            System.out.println("Not a Prime Number");

        sc.close();
    }
}