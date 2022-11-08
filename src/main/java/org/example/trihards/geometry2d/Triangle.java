package org.example.trihards.geometry2d;

/**
 * The Triangle class that implements shape interface to calculate perimeter and area.
 */
public class Triangle implements Shape{

    /**
     * The sides of the triangle
     */
    private double[] sides = new double[3];

    /**
     * The Base.
     */
    private double base;
    /**
     * The Height.
     */
    private double height;

    /**
     * Instantiates a new Triangle.
     *
     * @param sideOne   the side one
     * @param sideTwo   the side two
     * @param sideThree the side three
     */
    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.sides[0] = sideOne;
        this.sides[1] = sideTwo;
        this.sides[2] = sideThree;
    }

    /**
     * Instantiates a new Triangle.
     *
     * @param base   the base
     * @param height the height
     */
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }


    /**
     * Calculates perimeter of a triangle
     * @return perimeter of a triangle
     */
    @Override
    public double perimeter() {
        return sides[0] + sides[1] + sides[2];
    }

    /**
     * Calculates area of a triangle
     * @return area of a triangle
     */
    @Override
    public double area() {
        return (base * height) / 2;
    }
}
