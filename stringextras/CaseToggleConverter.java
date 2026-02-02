package extras;
import java.util.*;

/*
 * Toggles the case of each character in a string.
 */
public class CaseToggleConverter {

    // Toggles character case
    static String toggleCase(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') r += (char) (ch - 32);
            else if (ch >= 'A' && ch <= 'Z') r += (char) (ch + 32);
            else r += ch;
        }
        return r;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(toggleCase(sc.nextLine()));
    }
}
