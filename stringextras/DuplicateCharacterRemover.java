package extras;
import java.util.*;

/*
 * Removes duplicate characters from a string.
 */
public class DuplicateCharacterRemover {

    // Removes duplicate characters
    static String removeDuplicates(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (r.indexOf(ch) == -1) r += ch;
        }
        return r;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(removeDuplicates(sc.nextLine()));
    }
}
