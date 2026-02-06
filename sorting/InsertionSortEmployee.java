package sorting;
import java.util.Arrays;

public class InsertionSortEmployee {
    static void main() {
        int [] id = {9, 2,1,5,8,4,2,1,9};
        InsertionSort.insertionSort(id);
        System.out.println(Arrays.toString(id));
    }
}
