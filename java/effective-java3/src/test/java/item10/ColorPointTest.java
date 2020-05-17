package item10;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import item10.inheritance.ColorPoint;
import org.junit.jupiter.api.Test;

import java.awt.*;

class ColorPointTest {

    @Test
    void testEquals() {
        Point point = new Point(10, 10);
        ColorPoint colorPoint = new ColorPoint(10, 10, Color.CYAN);

        assertTrue(point.equals(colorPoint));
        assertFalse(colorPoint.equals(point));
    }
}
