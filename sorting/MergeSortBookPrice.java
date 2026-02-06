package sorting;
import java.util.Arrays;

public class MergeSortBookPrice {
    static void main() {
        int [] bookPrice = {1222, 543, 325, 768, 917, 1085};
        int n = bookPrice.length;
        MergeSort.mergeSort(bookPrice, 0, n-1);
        System.out.println(Arrays.toString(bookPrice));
    }
}
