// In this project, i'll learn the Java Core.

import data.Ex;
import data.SortingAlgorithm;

public class Core {
    public static void main(String[] args) {
        int[] arr = {5, 12, 34, 55, 66, 17, 18, 9, 12, 22, 15, 17};
        SortingAlgorithm.QuickSort(arr, 0, arr.length - 1);
        for (int x : arr) System.out.print(x + " ");
    }
}
