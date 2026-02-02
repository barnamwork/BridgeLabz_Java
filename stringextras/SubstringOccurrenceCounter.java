package extras;
import java.util.*;

/*
 * Counts occurrences of a substring within a string.
 */
public class SubstringOccurrenceCounter {

    // Counts substring occurrences
    static int countSubstring(String s, String sub) {
        int c = 0;
        for (int i = 0; i <= s.length() - sub.length(); i++) {
            if (s.substring(i, i + sub.length()).equals(sub)) c++;
        }
        return c;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sub = sc.nextLine();
        System.out.println(countSubstring(s, sub));
    }
}
