package data;

public class Ex {

    static public long Factorial (int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }

    static public void HarmonicSum (int n) {
//        int maxDenominator = n;
        double sumOfLeftToRight = 0.0;
        double sumOfRightToLeft = 0.0;

        for (int i = 1; i <= n; i++) {
            sumOfLeftToRight += (double) 1/i;
        }
        System.out.println("This is the sum from left to right " + sumOfLeftToRight);

        for (int i = 5000; i >= 1; i--) {
            sumOfRightToLeft += (double) 1/i;
        }
        System.out.println("This is the sum from right to left " + sumOfRightToLeft);

        if (sumOfLeftToRight > sumOfRightToLeft) {
            System.out.println("The sum from left to right is greater than the one from right to left");
        } else {
            System.out.println("The sum from right to left is greater than the one from left to right");
        }
    }

    static public void ExtractNumber (int n) {
        int number = n;
        int howManyNum = 1;
        int count = 0;
        do {
            howManyNum *= 10;
            count++;
        } while ((number / howManyNum) > 0);
        int[] arrayOfNums = new int[count];
        do {
            int extractNum = n % 10;
            arrayOfNums[count - 1] = extractNum;
            n /= 10;
            count--;
        } while (n > 0);
        for (int i : arrayOfNums) {
            System.out.print(i + " ");
        }
    }
}

//    public static void qsort (int[] list) {
//        quicksort(list, 0, list.length - 1);
//    }
//
//    private static void quicksort (int[] list, int left, int right) {
//        int i, j;
//        int x, y;
//        i = left; j = right;
//        x = list[(right + left) / 2]; // make a pivot
//
//        do {
//            while (list[i] < x && i < right) i++;
//            while (list[j] > x && j > left) j--;
//
//            if (i <= j) {
//                y = list[i];
//                list[i] = list[j];
//                list[j] = y; // swap
//                i++; j--;
//            }
//        } while (i <= j);
//
//        if (left < j) quicksort(list, left, j);
//        if (right > i) quicksort(list, i, right);
//    }
//}
