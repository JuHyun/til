package javabasic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GenericStackTest {

    @Test
    public void pushAType() {
        final GenericStack<A> stack = new GenericStack<>();

        for (int i = 1; i <= 5; i++) {
            stack.push(new A(i));
        }

        assertFalse(stack.empty());

        assertEquals(5, stack.pop().getNumber());
    }

    @Test
    public void pushBType() {
        final GenericStack<B> stack = new GenericStack<>();

        for (int i = 1; i <= 5; i++) {
            stack.push(new B(i * 2));
        }

        assertFalse(stack.empty());

        assertEquals(10, stack.pop().getNumber());
    }

    @Test
    public void usePushAll() {
        final ArrayList<A> aList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            aList.add(new A(i));
        }

        final GenericStack<A> genericStack = pushAllA(aList);

        assertEquals(5, genericStack.pop().getNumber());
    }

    @Test
    public void usePushAllWithBs() {
        final ArrayList<B> bList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            bList.add(new B(i * 2));
        }

        final GenericStack<A> genericStack = pushAllA(bList);

        assertEquals(10, genericStack.pop().getNumber());
    }

    private GenericStack<A> pushAllA(ArrayList<? extends A> listOfA) {
        final GenericStack<A> stack = new GenericStack<>();

        for (A a : listOfA) {
            stack.push(a);
        }

        return stack;
    }
}

