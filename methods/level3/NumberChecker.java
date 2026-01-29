package level3;

import java.util.Scanner;

public class NumberChecker {

    // a. Count digits
    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    // b. Store digits in array
    public static int[] getDigitsArray(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    // c. Duck number check (contains 0)
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0)
                return true;
        }
        return false;
    }

    // d. Armstrong number check
    public static boolean isArmstrong(int num, int[] digits) {
        int sum = 0;
        int power = digits.length;

        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == num;
    }

    // e. Largest & second largest
    public static int[] largestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    // f. Smallest & second smallest
    public static int[] smallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int[] digits = getDigitsArray(num);

        System.out.print("Digits: ");
        for (int d : digits)
            System.out.print(d + " ");

        System.out.println("\nDuck Number: " + isDuckNumber(digits));
        System.out.println("Armstrong Number: " + isArmstrong(num, digits));

        int[] large = largestAndSecondLargest(digits);
        System.out.println("Largest = " + large[0] + ", Second Largest = " + large[1]);

        int[] small = smallestAndSecondSmallest(digits);
        System.out.println("Smallest = " + small[0] + ", Second Smallest = " + small[1]);

        sc.close();
    }
}
