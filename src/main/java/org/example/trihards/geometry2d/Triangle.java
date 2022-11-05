package org.example.trihards.geometry2d;

/**
 * The Triangle class that implements shape interface to calculate perimeter and area.
 */
public class Triangle implements Shape{
    /**
     * The Side one.
     */
    public double sideOne;
    /**
     * The Side two.
     */
    public double sideTwo;
    /**
     * The Side three.
     */
    public double sideThree;
    /**
     * The Base.
     */
    public double base;
    /**
     * The Height.
     */
    public double height;

    /**
     * Instantiates a new Triangle.
     *
     * @param sideOne   the side one
     * @param sideTwo   the side two
     * @param sideThree the side three
     */
    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
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
        return sideOne + sideTwo + sideThree;
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
