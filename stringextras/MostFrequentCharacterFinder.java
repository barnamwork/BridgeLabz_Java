package extras;
import java.util.*;

/*
 * Finds the most frequent character in a string.
 */
public class MostFrequentCharacterFinder {

    // Finds most frequent character
    static char mostFrequent(String s) {
        int[] f = new int[256];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i)]++;
        int max = 0;
        char r = ' ';
        for (int i = 0; i < 256; i++) {
            if (f[i] > max) {
                max = f[i];
                r = (char) i;
            }
        }
        return r;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mostFrequent(sc.nextLine()));
    }
}
