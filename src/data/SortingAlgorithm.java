package data;

public class SortingAlgorithm {
    public static void MergeSort (int[] arr, int n) { //This version sorts all the members of the array
        if (n < 2) return;

        int mid = n / 2;
        int[] L = new int[mid];
        int[] R = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            L[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            R[i - mid] = arr[i];
        }

        MergeSort(L, mid);
        MergeSort(R, n - mid);

        Merge(arr, L, R, mid, n - mid);
    }

    public static void MergeSort (int[] arr, int begin, int end) { //This version sorts from specific index
        if (begin < end) {
            int mid = begin + (end - begin) / 2;

            MergeSort(arr, begin, mid);
            MergeSort(arr, mid + 1, end);

            Merge(arr, begin, mid, end);
        }
    }

    private static void Merge (int[] arr, int[] L, int[] R, int nL, int nR) {
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < nL) {
            arr[k++] = L[i++];
        }
        while (j < nR) {
            arr[k++] = R[j++];
        }
    }

    private static void Merge (int[] arr, int begin, int mid, int end) {
        int i, j, k = begin;
        int nL = mid - begin + 1;
        int nR = end - mid;

        int[] L = new int[nL];
        int[] R = new int[nR];

        for (i = 0; i < nL; i++) {
            L[i] = arr[begin + i];
        }
        for (j = 0; j < nR; j++) {
            R[j] = arr[mid + j + 1];
        }

        i = 0; j = 0;
        while (i < nL && j < nR) {
            arr[k++] = L[i] <= R[j] ? L[i++] : R[j++];
        }
        while (i < nL) {
            arr[k++] = L[i++];
        }
        while (j < nR) {
            arr[k++] = R[j++];
        }
    }

    public static void QuickSort (int[] arr, int begin, int end) { //This version sorts from specific index
        if (begin < end) {
            int indexPartition = Partition(arr, begin, end);

            QuickSort(arr, begin, indexPartition - 1);
            QuickSort(arr, indexPartition + 1, end);
        }
    }

    private static int Partition (int[] arr, int begin, int end) {
        int pivot = arr[end], k = begin - 1;

        for (int i = begin; i < end; i++) {
            if (arr[i] < pivot) {
                k++;

                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }

        int temp = arr[k + 1];
        arr[k + 1] = arr[end];
        arr[end] = temp;

        return k + 1;
    }

}
