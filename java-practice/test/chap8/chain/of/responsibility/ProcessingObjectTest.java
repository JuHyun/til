package chap8.chain.of.responsibility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ProcessingObjectTest {

    @Test
    public void test() {
        ProcessingObject<String> p1 = new HeaderTextProcessing<>();
        ProcessingObject<String> p2 = new SpellCheckerProcessing<>();

        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labda really sexy?!!");
        assertEquals("From Raoul, Mario and Alan: Aren't lambda really sexy?!!", result);
    }

    @Test
    public void lambda() {
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result = pipeline.apply("Aren't labda really sexy?!!");
        assertEquals("From Raoul, Mario and Alan: Aren't lambda really sexy?!!", result);
    }
}
