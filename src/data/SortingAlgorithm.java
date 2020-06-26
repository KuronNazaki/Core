package data;

public class SortingAlgorithm {
    public static void MergeSort (int[] numbers, int n) {

        if (n < 2) return;
        int mid = n / 2;

        int[] L = new int[mid];
        int[] R = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            L[i] = numbers[i];
        }
        for (int i = mid; i < n; i++) {
            R[i - mid] = numbers[i];
        }

        MergeSort(L, mid);
        MergeSort(R, n - mid);

        Merge(numbers, L, R, mid, n - mid);
    }

    public static void MergeSort (int[] numbers, int begin, int end) { //This version sorts from specific index
        if (begin < end) {
            int mid = begin + (end - begin) / 2;

            MergeSort(numbers, begin, mid);
            MergeSort(numbers, mid + 1, end);

            Merge(numbers, begin, mid, end);
        }
    }

    private static void Merge (int[] numbers, int[] L, int[] R, int nL, int nR) {
        int indexOfLeft = 0, indexOfRight = 0, indexOfOriginalArray = 0;
        
        while (indexOfLeft < nL && indexOfRight < nR) {
            numbers[indexOfOriginalArray++] =
                    (L[indexOfLeft] <= R[indexOfRight]) ? L[indexOfLeft++] : R[indexOfRight++];
        }
        while (indexOfLeft < nL) {
            numbers[indexOfOriginalArray++] = L[indexOfLeft++];
        }
        while (indexOfRight < nR) {
            numbers[indexOfOriginalArray++] = R[indexOfRight++];
        }
    }

    private static void Merge (int[] numbers, int begin, int mid, int end) {
        int i, j, k = begin;
        int nL = mid - begin + 1;
        int nR = end - mid;

        int[] L = new int[nL];
        int[] R = new int[nR];

        for (i = 0; i < nL; i++) {
            L[i] = numbers[begin + i];
        }
        for (j = 0; j < nR; j++) {
            R[j] = numbers[mid + j + 1];
        }

        i = 0; j = 0;
        while (i < nL && j < nR) {
            numbers[k++] = L[i] <= R[j] ? L[i++] : R[j++];
        }
        while (i < nL) {
            numbers[k++] = L[i++];
        }
        while (j < nR) {
            numbers[k++] = R[j++];
        }
    }

    public static void QuickSort (int[] numbers, int begin, int end) { //This version sorts from specific index
        if (begin < end) {
            int indexPartition = Partition(numbers, begin, end);

            QuickSort(numbers, begin, indexPartition - 1);
            QuickSort(numbers, indexPartition + 1, end);
        }
    }

    private static int Partition (int[] numbers, int begin, int end) {
        int endValue = numbers[end], pivotIndex = begin - 1;

        for (int i = begin; i < end; i++) {
            if (numbers[i] < endValue) {
                pivotIndex++;

                int temp = numbers[i];
                numbers[i] = numbers[pivotIndex];
                numbers[pivotIndex] = temp;
            }
        }

        int temp = numbers[pivotIndex + 1];
        numbers[pivotIndex + 1] = numbers[end];
        numbers[end] = temp;

        return pivotIndex + 1;
    }

    public static void SelectionSort (int[] numbers, int begin, int end) {
        for (int i = begin; i < end + 1; i++) {
            int minIndex = i;
            for (int k = i; k < end + 1; k++) {
                if (numbers[k] <= numbers[minIndex]) {
                    minIndex = k;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

}
