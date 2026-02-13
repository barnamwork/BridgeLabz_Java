package stackqueuehashmap;
import java.util.HashSet;

/*
Find length of longest consecutive sequence.

Example:
Input: 100, 4, 200, 1, 3, 2
Output: 4 (sequence: 1,2,3,4)
*/
class LongestConsecutiveSequence {

    static int longestSequence(int[] arr) {

        // HashSet allows O(1) lookup
        HashSet<Integer> set = new HashSet<>();

        // Store all elements
        for (int num : arr)
            set.add(num);

        int maxLength = 0;

        for (int num : set) {

            /*
            We start counting ONLY if num is the
            start of a sequence.
            If num-1 exists, then this is not a start.
            */
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int length = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                // Update maximum length
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestSequence(arr));
    }
}

