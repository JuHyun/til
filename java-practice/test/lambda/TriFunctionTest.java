package lambda;

import domain.Color;
import org.junit.Test;

public class TriFunctionTest {

    @Test
    public void tri() {
        TriFunction<Integer, Integer, Integer, Color> colorFactory = Color::new;
        Color color = colorFactory.apply(10, 10, 10);
        System.out.println(color.toString());
    }
}
