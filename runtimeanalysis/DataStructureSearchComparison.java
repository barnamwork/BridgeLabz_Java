package algorithms;
import java.util.*;

class DataStructureSearchComparison {

    public static void main(String[] args) {

        int n = 1_000_000;
        int target = n - 1;

        // Create data structures
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Fill all structures
        for (int i = 0; i < n; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        /* ============ Array Search (O(N)) ============ */
        long start = System.nanoTime();

        for (int x : array) {
            if (x == target)
                break;
        }

        System.out.println("Array Search Time: " +
                (System.nanoTime() - start) + " ns");

        /* ============ HashSet Search (O(1)) ============ */
        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet Search Time: " +
                (System.nanoTime() - start) + " ns");

        /* ============ TreeSet Search (O(log N)) ============ */
        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet Search Time: " +
                (System.nanoTime() - start) + " ns");
    }
}
