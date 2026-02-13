package algorithms;
import java.util.Arrays;

class SearchComparison {

    /*
     * Linear Search Method
     * Time Complexity: O(N)
     * It checks each element one by one until the target is found.
     */
    static int linearSearch(int[] arr, int target) {

        // Loop through every element of the array
        for (int i = 0; i < arr.length; i++) {

            // Check if current element matches target
            if (arr[i] == target) {
                return i; // Target found, return index
            }
        }

        // Target not found
        return -1;
    }

    /*
     * Binary Search Method
     * Time Complexity: O(log N)
     * Works only on sorted arrays.
     */
    static int binarySearch(int[] arr, int target) {

        int left = 0;                 // Starting index
        int right = arr.length - 1;   // Ending index

        // Continue search until left crosses right
        while (left <= right) {

            // Find middle index
            int mid = (left + right) / 2;

            // If middle element is target
            if (arr[mid] == target) {
                return mid;
            }
            // If target is greater, ignore left half
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {

        // Create a large dataset
        int[] arr = new int[1_000_000];

        // Fill array with values
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int target = 999_999;

        // Measure Linear Search time
        long start = System.nanoTime();
        linearSearch(arr, target);
        System.out.println("Linear Search Time: " +
                (System.nanoTime() - start) + " ns");

        // Sort array before Binary Search
        Arrays.sort(arr);

        // Measure Binary Search time
        start = System.nanoTime();
        binarySearch(arr, target);
        System.out.println("Binary Search Time: " +
                (System.nanoTime() - start) + " ns");
    }
}
