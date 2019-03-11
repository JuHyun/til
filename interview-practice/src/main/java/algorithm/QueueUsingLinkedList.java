package algorithm;

public class QueueUsingLinkedList<E> {

    private Node front, rear;
    private int size = 0;

    private class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public E dequeue() {
        if (empty()) return null;

        Node oldFront = front;
        front = oldFront.next;
        size--;

        return (E) oldFront.element;
    }

    public void enqueue(final E element) {
        Node oldRear = rear;
        rear = new Node(element);
        if (empty()) {
            front = rear;
        } else {
            oldRear.next = rear;
        }
        size++;
    }

    public boolean empty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }
}
