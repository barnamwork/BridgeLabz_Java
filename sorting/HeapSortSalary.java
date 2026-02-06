package sorting;

import java.util.Arrays;

public class HeapSortSalary {
    static void main() {
        int [] salary= {1000000, 1200000, 1400000, 450000, 350000 };
        int n = salary.length;
        HeapSort.heapSort(salary);
        System.out.println(Arrays.toString(salary));
    }
}
