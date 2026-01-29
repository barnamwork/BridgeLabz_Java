package level2;

import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int temp = number, count = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        int i = 0;

        while (number != 0) {
            digits[i++] = number % 10;
            number /= 10;
        }

        for (int j = 0; j < count; j++)
            System.out.print(digits[j]);

        sc.close();
    }
}
