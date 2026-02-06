package sorting;

import java.util.Arrays;
public class QuickSortProductPrice {
    static void main() {
        int [] productPrice = {54321, 87651, 95432,74321};
        int n = productPrice.length;
        QuickSort.quickSort(productPrice, 0 , n-1);
        System.out.println(Arrays.toString(productPrice));
    }
}
