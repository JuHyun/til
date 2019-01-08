package data.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostFrequencyNumberInArrayTest {

    @Test
    public void findMostFrequencyNumberAndCount() {
        final int[] numbers = {1, 2, 3, 3, 2, 5, 2, 6, 7, 10, 2};

        int[] mostFrequencyNumberAndCount = MostFrequencyNumberInArray.findMostFrequency(numbers);
        assertEquals(2, mostFrequencyNumberAndCount[0]);
        assertEquals(4, mostFrequencyNumberAndCount[1]);

        int[] mostFrequency = MostFrequencyNumberInArray.findMostFrequency(new int[]{10, 10, 10, 2, 5, 3, 3});
        assertEquals(10, mostFrequency[0]);
        assertEquals(3, mostFrequency[1]);
    }

    @Test
    public void shouldSort() {
        final int[] numbers = {1, 2, 5, 3, 10, 3, 2, 6, 7, 2};
        MostFrequencyNumberInArray.sorting(numbers);

        assertArrayEquals(new int[]{1, 2, 2, 2, 3, 3, 5, 6, 7, 10}, numbers);
    }
}
