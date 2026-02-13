package stackqueuehashmap;
import java.util.*;

/*
Find all subarrays whose sum is equal to zero.

Core idea:
- Use PREFIX SUM technique
- If the same prefix sum appears again,
  the elements between those indices sum to zero
*/
class ZeroSumSubarrays {

    static void findZeroSumSubarrays(int[] arr) {

        // HashMap to store:
        // key   -> prefix sum
        // value -> list of indices where this sum occurred
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int prefixSum = 0;

        /*
        Prefix sum = 0 before starting the array.
        Index -1 represents "before array starts".
        This helps detect subarrays starting from index 0.
        */
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        // Traverse array
        for (int i = 0; i < arr.length; i++) {

            // Add current element to prefix sum
            prefixSum += arr[i];

            /*
            If prefixSum already exists in map,
            then elements between previous index+1 and current index sum to zero
            */
            if (map.containsKey(prefixSum)) {

                // Multiple indices may exist for same prefix sum
                for (int startIndex : map.get(prefixSum)) {
                    System.out.println("Zero sum subarray from index "
                            + (startIndex + 1) + " to " + i);
                }
            }

            // Store current index for this prefix sum
            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        findZeroSumSubarrays(arr);
    }
}
