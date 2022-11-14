package org.example.trihards.geometry2d;

/**
 * The parallelogram class.
 */
public class Parallelogram implements Shape {

    /**
     * The length of the parallelogram.
     */
    private double length;

    /**
     * The width of the parallelogram.
     */
    private double width;

    /**
     * Instantiates a new parallelogram.
     */
    public Parallelogram() {
    }

    /**
     * Instantiates a new parallelogram with height and width.
     *
     * @param length the length
     * @param width  the width
     */
    public Parallelogram(double length, double width) {
        this();
        this.length = length;
        this.width = width;
    }

    /**
     * calculates the perimeter of the parallelogram
     * @return the perimeter
     */
    public double perimeter() {
        return 2 * (length + width);
    }

    /**
     * calculates the area of the parallelogram
     * @return the area
     */
    public double area() {
        return length * width;
    }
}
