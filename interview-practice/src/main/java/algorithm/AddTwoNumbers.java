package algorithm;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        ListNode currNode = result;
        int mock = 0;
        while (tempL1 != null & tempL2 != null) {
            int sum = tempL1.val + tempL2.val;
            int remain = sum % 10 + mock;
            mock = sum / 10;

            currNode.next = new ListNode(remain);
            currNode = currNode.next;

            tempL1 = tempL1.next;
            tempL2 = tempL2.next;
        }

        if (mock > 0) {
            currNode.next = new ListNode(mock);
        }

        return result.next;
    }
}
