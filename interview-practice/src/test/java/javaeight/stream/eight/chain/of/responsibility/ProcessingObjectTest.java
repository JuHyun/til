package javaeight.stream.eight.chain.of.responsibility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ProcessingObjectTest {

    @Test
    public void test() {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really sexy?!!");
        assertEquals("From Raoul, Mario and Alan: Aren't lambdas really sexy?!!", result);
    }

    @Test
    public void lambda() {
        UnaryOperator<String> headerTextProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerTextProcessing.andThen(spellCheckerProcessing);
        String result = pipeline.apply("Aren't labdas really sexy?!!");
        assertEquals("From Raoul, Mario and Alan: Aren't lambdas really sexy?!!", result);
    }
}
