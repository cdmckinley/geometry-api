package org.example.trihards.response;

import org.example.trihards.geometry2d.Shape;

public class Response2d {
    private Object perimeter;
    private Object area;

    public Object getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Shape shape) {
        double perimeter = shape.perimeter();
        if (perimeter > 0.0) this.perimeter = perimeter;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Shape shape) {
        double area = shape.area();
        if (area > 0.0) this.area = area;
    }
}
