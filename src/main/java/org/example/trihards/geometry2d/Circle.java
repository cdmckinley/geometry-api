package org.example.trihards.geometry2d;

/**
 * The Circle class that implements shape interface to calculate perimeter and area.
 */
public class Circle implements Shape {

    /**
     * The Radius.
     */
    private double radius;

    /**
     * Instantiates a new Circle.
     */
    public Circle() {

    }

    /**
     * Instantiates a new Circle with a radius.
     *
     * @param radius the radius
     */
    public Circle(double radius){
        this();
        this.radius = radius;
    }

    /**
     * Calculates perimeter of a circle
     * @return perimeter of a circle
     */
    @Override
    public double perimeter() {

        return 2 * Math.PI * radius;
    }

    /**
     * Calculates are of a circle
     * @return area of a circle.
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

}
