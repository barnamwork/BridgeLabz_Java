package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n-1; i++) {
            int j = i ;
            // Move elements that are greater than key to one position ahead
            while (j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j]=temp;
                j--;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }




}
