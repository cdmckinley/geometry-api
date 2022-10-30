package org.example.trihards.geometry2d;

public class Rectangle implements Polygon {

    public int length;

    public int width;

    public Rectangle() {
    }

    public Rectangle(int length, int width) {
        this();
        this.length = length;
        this.width = width;
    }

    public int perimeter() {
        return 2 * (length + width);
    }

    public int area() {
        return length * width;
    }
}
