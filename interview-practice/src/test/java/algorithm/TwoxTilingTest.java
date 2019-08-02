package algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwoxTilingTest {

    @Test
    public void test() {
        TwoxTiling twoxTiling1 = new TwoxTiling(1);
        assertEquals(1, twoxTiling1.solution(1));

        TwoxTiling twoxTiling2 = new TwoxTiling(2);
        assertEquals(2, twoxTiling2.solution(2));

        TwoxTiling twoxTiling3 = new TwoxTiling(3);
        assertEquals(3, twoxTiling3.solution(3));

        TwoxTiling twoxTiling4 = new TwoxTiling(4);
        assertEquals(5, twoxTiling4.solution(4));

        TwoxTiling twoxTiling5 = new TwoxTiling(5);
        assertEquals(8, twoxTiling5.solution(5));

        TwoxTiling twoxTiling9 = new TwoxTiling(9);
        assertEquals(55, twoxTiling9.solution(9));
    }
}
