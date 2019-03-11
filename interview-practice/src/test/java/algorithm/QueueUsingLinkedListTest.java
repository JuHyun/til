package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QueueUsingLinkedListTest {

    @Test
    public void queue() {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(2, queue.size());
    }
}
