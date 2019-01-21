package data.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class InsertElementToLinkedListTest {

    private List<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new LinkedList<Integer>();
        ((LinkedList<Integer>) numbers).push(9);
        ((LinkedList<Integer>) numbers).push(7);
        ((LinkedList<Integer>) numbers).push(5);
        ((LinkedList<Integer>) numbers).push(3);
        ((LinkedList<Integer>) numbers).push(1);
    }

    @Test
    public void suceess() {
        assertEquals(5, numbers.get(2));

        List<Integer> insert = InsertElementToLinkedList.insert(numbers, 4);

        insert.stream().forEach(System.out::println);

        assertEquals(4, insert.get(2));
        assertEquals(5, insert.get(3));
//        System.out.println("------------------");
//        List<Integer> insert1 =
//                InsertElementToLinkedList.insert(new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9)), 8);
//        insert1.stream().forEach(System.out::println);
//        assertEquals(8, insert1.get(4));
    }

    @Test
    public void suceess2() {
        assertEquals(5, numbers.get(2));

//        List<Integer> insert = InsertElementToLinkedList.insertWithQuickSort(numbers, 4);
//
//        insert.stream().forEach(System.out::println);
//
//        assertEquals(4, insert.get(2));
//        assertEquals(5, insert.get(3));
//        System.out.println("------------------");
//        List<Integer> insert1 =
//                InsertElementToLinkedList.insertWithQuickSort(new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9)), 10);
//        insert1.stream().forEach(System.out::println);
//        assertEquals(10, insert1.get(5));
//
        List<Integer> insert3 =
                InsertElementToLinkedList.insertWithQuickSort(new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9)), 8);
        insert3.stream().forEach(System.out::println);
        assertEquals(8, insert3.get(4));

//        List<Integer> insert4 =
//                InsertElementToLinkedList.insertWithQuickSort(new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9)), 0);
//        insert4.stream().forEach(System.out::println);
//        assertEquals(0, insert4.get(0));
//        assertEquals(1, insert4.get(1));
    }
}
