package chap5.item29;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class StackTest {

    @Test
    void push() {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("!");

        assertFalse(stack.isEmpty());
    }

    @Test
    void pop() {
        Stack<String> stack = new Stack();
        stack.push("hello");
        stack.push("world");
        stack.push("!");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }

    @Test
    void isEmpty() {
    }
}
