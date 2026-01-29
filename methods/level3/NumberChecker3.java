package level3;

import java.util.Scanner;

public class NumberChecker3 {

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

    // 3. Reverse digits array
    public static int[] reverseArray(int[] digits) {
        int[] rev = new int[digits.length];
        int index = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            rev[index++] = digits[i];
        }
        return rev;
    }

    // 4. Compare two arrays
    public static boolean compareArrays(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    // 5. Palindrome check using digits
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    // 6. Duck number check (contains 0)
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int[] digits = getDigitsArray(num);

        System.out.print("Digits: ");
        for (int d : digits)
            System.out.print(d + " ");

        int[] reversed = reverseArray(digits);

        System.out.print("\nReversed Digits: ");
        for (int d : reversed)
            System.out.print(d + " ");

        System.out.println("\nPalindrome Number: " + isPalindrome(digits));
        System.out.println("Duck Number: " + isDuckNumber(digits));

        sc.close();
    }
}
