// In this project, i'll learn the Java Core.

import data.Ex;

public class Core {
    public static void main(String[] args) {
        int[] arr = {5, 12, 34, 55, 66, 17, 18, 9, 12, 22, 15, 17};
        QuickSort(arr, 0, arr.length - 1);
        for (int x : arr) System.out.print(x + " ");
    }

    static void QuickSort (int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = Partition(arr, begin, end);

            QuickSort(arr, begin, partitionIndex - 1);
            QuickSort(arr, partitionIndex + 1, end);
        }
    }

    static int Partition (int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i] ;
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}
