package extras;
import java.util.*;

/*
 * Removes a specific character from a string.
 */
public class CharacterRemover {

    // Removes given character
    static String removeChar(String s, char c) {
        String r = "";
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != c) r += s.charAt(i);
        return r;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = sc.next().charAt(0);
        System.out.println(removeChar(s, c));
    }
}
