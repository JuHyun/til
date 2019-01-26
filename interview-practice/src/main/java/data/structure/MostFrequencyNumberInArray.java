package data.structure;

import java.util.Arrays;

public class MostFrequencyNumberInArray {

    public static int[] findMostFrequency(final int[] numbers) {
        sorting(numbers);

        int maxCount = 1, currentCount = 1;
        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i]) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxNumber = numbers[i - 1];
                }
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxNumber = numbers[numbers.length - 1];
        }

        return new int[]{maxNumber, maxCount};
    }

    public static void sorting(final int[] numbers) {
        Arrays.sort(numbers);
    }
}
