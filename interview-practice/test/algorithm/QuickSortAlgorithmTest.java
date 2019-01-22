package algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class QuickSortAlgorithmTest {

    @Test
    public void quickSrot() {
        int[] array1 = {1, 3, 0, 4, 2};
        QuickSortAlgorithm.quickSort(array1);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, array1);


        int[] array2 = {5, 4, 3, 4, 2, 1};
        QuickSortAlgorithm.quickSort(array2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5}, array2);
    }
}
