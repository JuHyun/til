package chap5.item30;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

class GenericSingletonFactoryTest {

    @Test
    void identityFunction() {

        String[] strings = {"hello", "world", "!"};
        UnaryOperator<String> sameString = UnaryOperator.identity();
        for (String s: strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 20.1, 3L, 10.333f };
        UnaryOperator<Number> sameNumber = UnaryOperator.identity();
        for (Number s: numbers) {
            System.out.println(sameNumber.apply(s));
        }
    }
}
