package level2;

import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int each = chocolates / children;
        int remaining = chocolates % children;

        System.out.println("The number of chocolates each child gets is "
                + each + " and the number of remaining chocolates are " + remaining);
    }
}
