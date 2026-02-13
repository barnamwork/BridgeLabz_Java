package stackqueuehashmap;
import java.util.HashMap;

/*
Check if there exists a pair with given sum.

Logic:
- For each element x
- Check if (target - x) already exists
*/
class PairWithGivenSum {

    static boolean hasPair(int[] arr, int target) {

        // HashMap stores elements already visited
        HashMap<Integer, Boolean> seen = new HashMap<>();

        for (int num : arr) {

            // Value required to make sum = target
            int complement = target - num;

            /*
            If complement exists in map,
            then num + complement = target
            */
            if (seen.containsKey(complement)) {
                System.out.println("Pair found: " + num + " + " + complement);
                return true;
            }

            // Mark current number as visited
            seen.put(num, true);
        }

        // No pair found
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        System.out.println(hasPair(arr, 10));
    }
}

