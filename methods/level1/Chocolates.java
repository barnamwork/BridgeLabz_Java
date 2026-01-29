package level1;

import java.util.Scanner;

public class Chocolates {
    public static int[] distribute(int chocolates, int children) {
        return new int[]{chocolates / children, chocolates % children};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int chocolates = sc.nextInt();
        int children = sc.nextInt();

        int[] result = distribute(chocolates, children);

        System.out.println("Each child gets = " + result[0]);
        System.out.println("Remaining chocolates = " + result[1]);
    }
}
