package algorithms;
import java.util.Arrays;

class SortingComparison {

    /*
     * Bubble Sort Algorithm
     * Time Complexity: O(N²)
     * Repeatedly swaps adjacent elements if they are in wrong order.
     */
    static void bubbleSort(int[] arr) {

        // Outer loop controls number of passes
        for (int i = 0; i < arr.length; i++) {

            // Inner loop performs comparisons
            for (int j = 0; j < arr.length - i - 1; j++) {

                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Create dataset
        int[] arr1 = new int[10000];

        // Fill array with random numbers
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 10000);
        }

        // Clone array for fair comparison
        int[] arr2 = arr1.clone();

        // Bubble Sort timing
        long start = System.nanoTime();
        bubbleSort(arr1);
        System.out.println("Bubble Sort Time: " +
                (System.nanoTime() - start) + " ns");

        // Java built-in efficient sort (Quick / Merge internally)
        start = System.nanoTime();
        Arrays.sort(arr2);
        System.out.println("Efficient Sort Time: " +
                (System.nanoTime() - start) + " ns");
    }
}

