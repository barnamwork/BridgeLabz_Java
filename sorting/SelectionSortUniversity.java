package sorting;

import java.util.Arrays;

public class SelectionSortUniversity {
    static void main() {
        int [] examScore = { 98, 34, 99, 29, 19, 5};
        int n = examScore.length;
        SelectionSort.selectionSort(examScore);
        System.out.println(Arrays.toString(examScore)   );
    }
}
