package item10.composition;

import item10.Point;

import java.awt.*;
import java.util.Objects;

public class ColorPoint {

    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorPoint)) return false;
        ColorPoint that = (ColorPoint) o;
        return that.point.equals(this.point) && that.color.equals(this.color);
    }
}
