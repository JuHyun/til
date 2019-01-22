package algorithm;

public class SingleLinkedList {

    private ListNode head;

    class ListNode {

        private int data;

        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

    }

    public void printAll() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public ListNode getNthNode(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can't less than zero.");
        }

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            if (index == count) {
                break;
            }
            curr = curr.next;
            count++;
        }

        if (index > count) {
            throw new IllegalArgumentException("index can't greather than list size.");
        }

        return curr;
    }

    public void insertNode(int data) {
        if (head == null || head.data > data) {
            insertAtBeginning(data);
            return;
        }

        ListNode newNode = new ListNode(data);

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.data < data) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = newNode;
        if (prev.next != null) {
            prev.next = newNode;
            newNode.next = curr;
        }
    }
}
