package extras;
import java.util.*;

/*
 * Finds the longest word in a sentence.
 */
public class LongestWordFinder {

    // Finds the longest word
    static String longestWord(String s) {
        String[] w = s.split(" ");
        String max = "";
        for (String x : w) if (x.length() > max.length()) max = x;
        return max;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(longestWord(sc.nextLine()));
    }
}
