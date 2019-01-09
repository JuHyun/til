package design.pattern.decorator;

import org.junit.jupiter.api.Test;

public class ShapeDecoratorTest {

    @Test
    public void shouldAddFuntionsWithoutOriginalChange() {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();

        Shape decoratedShape = new LineThicknessDecorator(new LineStyleDecorator(new LineColorDecorator(new FillColorDecorator(circle, Color.GREEN), Color.MAROON), LineStyle.DOT), 2.3);
        decoratedShape.draw();
    }
}