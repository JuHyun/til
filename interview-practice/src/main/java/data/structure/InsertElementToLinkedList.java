package data.structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertElementToLinkedList {

    static int insertedIndx = 0;
    static boolean insertion = false;

    public static List<Integer> insert(List<Integer> numbers, int addedNumber) {
        if (numbers == null) {
            return new LinkedList(Arrays.asList(addedNumber));
        }

        if (numbers.size() == 0) {
            numbers.add(addedNumber);
            return numbers;
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) <= addedNumber && addedNumber <= numbers.get(i + 1)) {
                numbers.add(i + 1, addedNumber);
                break;
            }
        }

        return numbers;
    }

    public static List<Integer> insertWithQuickSort(List<Integer> numbers, int addedNumber) {

        insertedIndx = numbers.size() / 2;
        int index = recursiveSearch(numbers, addedNumber);

        numbers.add(index + 1, addedNumber);

        return numbers;
    }

    public static int recursiveSearch(List<Integer> numbers, int addedNumber) {
        int searchIndex = numbers.size() / 2;

        if (numbers.get(searchIndex) == addedNumber) {
            return searchIndex;
        }

        if (numbers.get(searchIndex) < addedNumber) {
            if (insertion) {
                return insertedIndx;
            }
            if (searchIndex >= numbers.size()) {
                return insertedIndx;
            }
            insertion = true;
            insertedIndx += searchIndex;
            List<Integer> rightList = numbers.subList(searchIndex, numbers.size());
            return recursiveSearch(rightList, addedNumber);
        }

        insertion = false;
        insertedIndx -= searchIndex;
        if (searchIndex == 0) {
            return insertedIndx;
        }
        List<Integer> leftList = numbers.subList(0, searchIndex);
        return recursiveSearch(leftList, addedNumber);
    }
}
