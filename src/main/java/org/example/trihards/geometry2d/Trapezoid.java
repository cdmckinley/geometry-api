package org.example.trihards.geometry2d;

/**
 * The Trapezoid class implements shape interface to calculate perimeter and area.
 */
public class Trapezoid implements Shape{
    /**
     * The Base one.
     */
    public double baseOne;
    /**
     * The Base two.
     */
    public double baseTwo;
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
     * The Side four.
     */
    public double sideFour;
    /**
     * The Height.
     */
    public double height;

    /**
     * Instantiates a new Trapezoid.
     *
     * @param sideOne   the side one
     * @param sideTwo   the side two
     * @param sideThree the side three
     * @param sideFour  the side four
     */
    public Trapezoid(double sideOne, double sideTwo, double sideThree, double sideFour) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
        this.sideFour = sideFour;
    }

    /**
     * Instantiates a new Trapezoid.
     *
     * @param baseOne the base one
     * @param baseTwo the base two
     * @param height  the height
     */
    public Trapezoid(double baseOne, double baseTwo, double height) {
        this.baseOne = baseOne;
        this.baseTwo = baseTwo;
        this.height = height;
    }


    /**
     * Calculates perimeter of a trapezoid
     * @return perimeter of a trapezoid
     */
    @Override
    public double perimeter() {
        return sideOne + sideTwo + sideThree + sideFour;
    }

    /**
     * Calculates area of a trapezoid
     * @return area of a trapezoid
     */
    @Override
    public double area() {
        return 0.5 * (baseOne + baseTwo) * height;
    }
}
