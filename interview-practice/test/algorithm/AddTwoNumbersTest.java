package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {

    @Test
    public void success() {
        AddTwoNumbers.ListNode firstListNode = createListNodes(new int[]{2, 4, 3});
        AddTwoNumbers.ListNode secondListNode = createListNodes(new int[]{5, 6, 4});

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        AddTwoNumbers.ListNode listNode = addTwoNumbers.addTwoNumbers(firstListNode, secondListNode);
        assertEquals(7, listNode.val);
        assertEquals(0, listNode.next.val);
        assertEquals(8, listNode.next.next.val);

    }

    private AddTwoNumbers.ListNode createListNodes(final int[] array) {
        AddTwoNumbers.ListNode first = new AddTwoNumbers.ListNode(array[0]);
        AddTwoNumbers.ListNode second = new AddTwoNumbers.ListNode(array[1]);
        AddTwoNumbers.ListNode third = new AddTwoNumbers.ListNode(array[2]);
        first.next = second;
        second.next = third;

        return first;
    }

}
