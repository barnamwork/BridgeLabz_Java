import java.util.*;

/*
 * Implements a number guessing game using binary search logic
 * where the program guesses a number based on user feedback.
 */
public class NumberGuessingGame {

    // Generates a guess between low and high
    static int guess(int low, int high) {
        return low + (high - low) / 2;
    }

    // Program entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        while (true) {
            int g = guess(low, high);
            System.out.println(g);
            String feedback = sc.next();
            if (feedback.equals("correct")) break;
            if (feedback.equals("high")) high = g - 1;
            if (feedback.equals("low")) low = g + 1;
        }
    }
}
