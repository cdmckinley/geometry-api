package org.example.trihards.geometry2d;

/**
 * The Rectangle class.
 */
public class Rectangle implements Polygon {

    /**
     * The length of the rectangle.
     */
    public int length;

    /**
     * The width of the rectangle.
     */
    public int width;

    /**
     * Instantiates a new Rectangle.
     */
    public Rectangle() {
    }

    /**
     * Instantiates a new Rectangle with height and width.
     *
     * @param length the length
     * @param width  the width
     */
    public Rectangle(int length, int width) {
        this();
        this.length = length;
        this.width = width;
    }

    /**
     * calculates the perimeter of the rectangle
     * @return the perimeter
     */
    public int perimeter() {
        return 2 * (length + width);
    }

    /**
     * calculates the area of the rectangle
     * @return the area
     */
    public int area() {
        return length * width;
    }
}
