package org.example.trihards.geometry2d;

/**
 * The Trapezoid class implements shape interface to calculate perimeter and area.
 */
public class Trapezoid implements Shape{
    /**
     * The base sides, or the two parallel sides.
     */
    private double[] bases = new double[2];

    /**
     * The sides.
     */
    private double[] sides = new double[4];
    /**
     * The Height.
     */
    private double height;

    /**
     * Instantiates a new Trapezoid.
     *
     * @param sideOne   the side one
     * @param sideTwo   the side two
     * @param sideThree the side three
     * @param sideFour  the side four
     */
    public Trapezoid(double sideOne, double sideTwo, double sideThree, double sideFour) {
        this.sides[0] = sideOne;
        this.sides[1] = sideTwo;
        this.sides[2] = sideThree;
        this.sides[3] = sideFour;
    }

    /**
     * Instantiates a new Trapezoid.
     *
     * @param baseOne the base one
     * @param baseTwo the base two
     * @param height  the height
     */
    public Trapezoid(double baseOne, double baseTwo, double height) {
        this.bases[0] = baseOne;
        this.bases[1] = baseTwo;
        this.height = height;
    }


    /**
     * Calculates perimeter of a trapezoid
     * @return perimeter of a trapezoid
     */
    @Override
    public double perimeter() {
        return sides[0] + sides[1] + sides[2] + sides[3];
    }

    /**
     * Calculates area of a trapezoid
     * @return area of a trapezoid
     */
    @Override
    public double area() {
        return 0.5 * (bases[0] + bases[1]) * height;
    }
}
