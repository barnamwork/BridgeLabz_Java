package sorting;

import java.util.Arrays;

public class CountingSortAges {
    static void main() {
        int[] ages = { 18, 12, 17,15,14,15,16,14,13,11,10,17 };
        int n=ages.length;
        CountingSort.countingSort(ages);
        System.out.println(Arrays.toString(ages));
    }
}
