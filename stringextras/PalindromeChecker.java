package extras;
import java.util.*;

/*
 * Checks whether a string is a palindrome.
 */
public class PalindromeChecker {

    // Checks palindrome using two pointers
    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isPalindrome(sc.nextLine()));
    }
}
