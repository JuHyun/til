package javabasic;

import java.util.LinkedList;
import java.util.List;

public class GenericStack<E> {

    private final List<E> values;

    public GenericStack() {
        this.values = new LinkedList<E>();
    }

    public void push(final E element) {
        values.add(0, element);
    }

    public boolean empty() {
        return values.size() <= 0;
    }

    public E pop() {
        if (values.size() == 0) {
            return null;
        }
        return values.remove(0);
    }
}
