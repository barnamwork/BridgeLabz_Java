package extras;
import java.util.*;

/*
 * Counts the number of vowels and consonants in a given string.
 */
public class VowelConsonantCounter {

    // Counts vowels and consonants
    static int[] count(String s) {
        int v = 0, c = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') v++;
                else c++;
            }
        }
        return new int[]{v, c};
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] r = count(sc.nextLine());
        System.out.println("Vowels:" + r[0]);
        System.out.println("Consonants:" + r[1]);
    }
}
