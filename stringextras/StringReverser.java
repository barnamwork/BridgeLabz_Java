package extras;
import java.util.*;

/*
 * Reverses a given string.
 */
public class StringReverser {

    // Reverses the string
    static String reverse(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) r += s.charAt(i);
        return r;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(reverse(sc.nextLine()));
    }
}
