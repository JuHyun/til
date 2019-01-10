package javabasic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GenericStackATest {

    @Test
    public void usePushAllA() {
        final ArrayList<A> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new A());
        }

        final GenericStackA genericStackA = pushAllA(list);

        assertNotNull(genericStackA.pop());
    }

    @Test
    public void usePushAllB() {
        final ArrayList<B> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new B());
        }

        final GenericStackA genericStackB = pushAllA(list);

        assertNotNull(genericStackB.pop());
    }


    public static GenericStackA<A> pushAllA(final List<? extends A> listOfA) {
        GenericStackA<A> stackA = new GenericStackA<>();
        for (A a : listOfA) {
            stackA.push(a);
        }

        return stackA;
    }
}