package design.pattern.template.method;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(i + 1);
        }
    }

    @Test
    public void evenPredicate() {
        final Stack filtered = stack.filter(new EvenStackPredicate());

        assertEquals(Integer.valueOf(10), filtered.pop());
        assertEquals(Integer.valueOf(8), filtered.pop());
        assertEquals(Integer.valueOf(6), filtered.pop());
    }

    @Test
    public void allPredicate() {
        final Stack filtered = stack.filter(new AllStackPredicate());

        assertEquals(Integer.valueOf(10), filtered.pop());
        assertEquals(Integer.valueOf(9), filtered.pop());
        assertEquals(Integer.valueOf(8), filtered.pop());
    }

    private class EvenStackPredicate implements Stack.StackPredicate {
        @Override
        public boolean isValid(int i) {
            return i % 2 == 0;
        }
    }

    private class AllStackPredicate implements Stack.StackPredicate {
        @Override
        public boolean isValid(int i) {
            return true;
        }
    }
}
