package item10.composition;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import item10.Point;
import item10.inheritance.ColorPoint;
import org.junit.jupiter.api.Test;

import java.awt.*;


class ColorPointTest {

    @Test
    void testEquals() {
        item10.inheritance.ColorPoint colorPoint1 = new ColorPoint(10, 10, Color.GRAY);
        Point point = new Point(10, 10);
        item10.composition.ColorPoint colorPoint2 = new item10.composition.ColorPoint(10, 10, Color.BLACK);

        assertFalse(colorPoint1.equals(point));
        assertTrue(point.equals(colorPoint2));
        assertFalse(colorPoint1.equals(colorPoint2));

    }
}
