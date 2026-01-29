package level3;

import java.util.Scanner;

public class NumberChecker2 {

    // 1. Count digits
    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    // 2. Store digits in array
    public static int[] getDigitsArray(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    // 3. Sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // 4. Sum of squares of digits
    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // 5. Harshad number check
    public static boolean isHarshadNumber(int num, int[] digits) {
        int sum = sumOfDigits(digits);
        return num % sum == 0;
    }

    // 6. Digit frequency using 2D array
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        // initialize digit column
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        // count frequency
        for (int d : digits) {
            freq[d][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int[] digits = getDigitsArray(num);

        System.out.print("Digits: ");
        for (int d : digits)
            System.out.print(d + " ");

        System.out.println("\nSum of digits = " + sumOfDigits(digits));
        System.out.println("Sum of squares = " + sumOfSquares(digits));
        System.out.println("Harshad Number = " + isHarshadNumber(num, digits));

        int[][] freq = digitFrequency(digits);

        System.out.println("\nDigit Frequency:");
        System.out.println("Digit  Frequency");
        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0)
                System.out.println(freq[i][0] + "        " + freq[i][1]);
        }

        sc.close();
    }
}