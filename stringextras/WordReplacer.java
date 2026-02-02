package extras;
import java.util.*;

/*
 * Replaces a word in a sentence with another word.
 */
public class WordReplacer {

    // Replaces occurrences of a word
    static String replaceWord(String s, String oldWord, String newWord) {
        String[] w = s.split(" ");
        String r = "";
        for (String x : w) {
            if (x.equals(oldWord)) r += newWord + " ";
            else r += x + " ";
        }
        return r.trim();
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String o = sc.next();
        String n = sc.next();
        System.out.println(replaceWord(s, o, n));
    }
}
