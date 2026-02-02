package extras;
import java.util.*;

/*
 * Compares two strings lexicographically.
 */
public class LexicographicalStringComparator {

    // Compares two strings manually
    static int compare(String a, String b) {
        int n = Math.min(a.length(), b.length());
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i))
                return a.charAt(i) - b.charAt(i);
        }
        return a.length() - b.length();
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int r = compare(s1, s2);
        if (r < 0) System.out.println(s1 + " comes before " + s2);
        else if (r > 0) System.out.println(s2 + " comes before " + s1);
        else System.out.println("Both are equal");
    }
}
