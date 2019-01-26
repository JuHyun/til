package algorithm;

import java.util.Arrays;

public class QuickSortAlgorithm {
    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) return;

        int partitionPosition = partition(array, start, end);
        sort(array, start, partitionPosition - 1);
        sort(array, partitionPosition, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = getPivot(array, start, end);

        while (start <= end) {
            while (array[start] < pivot) {
                start++;
            }
            while (array[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(start, array, end);
                start++;
                end--;
                Arrays.stream(array).forEach(System.out::print);
                System.out.println();
            }
        }
        return start;
    }

    private static int getPivot(int[] array, int start, int end) {
        return array[(start + end) / 2];
    }

    private static void swap(int start, int[] array, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
