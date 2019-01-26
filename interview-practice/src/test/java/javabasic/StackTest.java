package javabasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    @Test
    public void success() {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        assertEquals("3", stack.pop());
    }

    @Test
    public void successGeneric() {
        GenericStack<Stack> genericStack = new GenericStack<>();
        genericStack.push(makeStake("abcde", 5));
        genericStack.push(makeStake("xyz", 3));

        assertEquals(makeStake("xyz", 3).pop(), genericStack.pop().pop());
    }

    private Stack makeStake(String value, int iterator) {
        Stack stack = new Stack();
        for (int i = 0; i < iterator; i++) {
            stack.push(value);
        }
        return stack;
    }
}