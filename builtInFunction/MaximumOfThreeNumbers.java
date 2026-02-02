import java.util.*;

/*
 * Finds the maximum of three integers.
 */
public class MaximumOfThreeNumbers {

    // Returns the maximum of three numbers
    static int max(int a, int b, int c) {
        int m = a > b ? a : b;
        return m > c ? m : c;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println(max(x, y, z));
    }
}
