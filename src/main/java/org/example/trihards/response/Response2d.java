package org.example.trihards.response;

import org.example.trihards.geometry2d.Shape;

public class Response2d {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Shape shape) {
        this.perimeter = shape.perimeter();
    }

    public double getArea() {
        return area;
    }

    public void setArea(Shape shape) {
        this.area = shape.area();
    }
}
