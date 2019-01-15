package jvm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StackAndHeapTest {

    @Test
    public void listReversal() {
        final List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> expectedList = Arrays.asList(5, 4, 3, 2, 1);

        assertEquals(expectedList.size(), reverseRecursive(givenList).size());
        assertEquals(expectedList.size(), reverseIterative(givenList).size());
    }

    private List<Integer> reverseIterative(List<Integer> list) {
        int size = list.size();
        for (int index = 0; index < size / 2; index++) {
            int right = size - index - 1;
            Integer temp = list.get(index);
            list.set(index, list.get(right));
            list.set(right, temp);
        }
        return list;
    }

    private List<Integer> reverseRecursive(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        List<Integer> newList = new ArrayList<>();
        newList.add(list.get(list.size() - 1));
        newList.addAll(reverseRecursive(list.subList(0, list.size() - 1)));
        return newList;
    }
}
