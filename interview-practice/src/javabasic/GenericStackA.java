package javabasic;

import java.util.LinkedList;
import java.util.List;

public class GenericStackA<A> {

    private final List<A> values;

    public GenericStackA() {
        values = new LinkedList<>();
    }

    public void push(A e) {
        values.add(0, e);
    }

    public A pop() {
        if (values.size() == 0) return null;
        return values.remove(0);
    }
}
