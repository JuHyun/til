package javabasic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private final Stack stack = new Stack();

    private final String REMOVED = "string literal";

    @BeforeEach
    public void setUp() {
        stack.push(1L);
        stack.push(REMOVED);
    }

    @Test
    public void makeStack() {
        assertFalse(stack.empty());
    }

    @Test
    public void pop() {
        assertEquals(REMOVED, stack.pop());
    }
}
