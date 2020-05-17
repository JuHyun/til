package item23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FigureTest {

    @Test
    public void area() {
        Circle circle = new Circle(10);
        assertEquals(Math.PI * 10 * 10, circle.area());

        Square square = new Square(10.2f);
        assertEquals(10.2f * 10.2f, square.area(), 0.001);
    }
}
