package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleLinkedListTest {

    private SingleLinkedList linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new SingleLinkedList();
        linkedList.insertAtBeginning(11);
        linkedList.insertAtBeginning(9);
        linkedList.insertAtBeginning(7);
        linkedList.insertAtBeginning(5);
        linkedList.insertAtBeginning(3);
        linkedList.insertAtBeginning(1);
    }

    @Test
    public void getNthNode() {
        assertEquals(linkedList.getNthNode(0).getData(), 1);
        assertEquals(linkedList.getNthNode(1).getData(), 3);
        assertEquals(linkedList.getNthNode(2).getData(), 5);
        assertEquals(linkedList.getNthNode(3).getData(), 7);
        assertEquals(linkedList.getNthNode(4).getData(), 9);
        assertEquals(linkedList.getNthNode(5).getData(), 11);
    }

    @Test
    public void insertNode() {
        linkedList.insertNode(0);
        assertEquals(0, linkedList.getNthNode(0).getData());

        linkedList.insertNode(4);
        assertEquals(4, linkedList.getNthNode(3).getData());

        linkedList.insertNode(13);
        assertEquals(13, linkedList.getNthNode(8).getData());
    }
}