package design.pattern.decorator;

public class LineStyleDecorator extends ShapeDecorator {

    protected LineStyle lineStyle;

    public LineStyleDecorator(Shape decoratedShape, LineStyle lineStyle) {
        super(decoratedShape);
        this.lineStyle = lineStyle;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Line Style " + lineStyle);
    }

    @Override
    public void resize() {
        decoratedShape.resize();
    }

    @Override
    public String description() {
        return decoratedShape.description() + " drawn with " + lineStyle + " lines.";
    }

    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
