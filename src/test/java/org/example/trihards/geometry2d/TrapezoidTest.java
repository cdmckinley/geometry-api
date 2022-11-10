package org.example.trihards.geometry2d;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The tests for Trapezoid class.
 */

public class TrapezoidTest {

    /**
     * Tests perimeter calculation of a trapezoid.
     */
    @Test
    public void calculatePerimeterSuccess() {
        Trapezoid trapezoid = new Trapezoid(7,8,9, 2);
        assertEquals(26, trapezoid.perimeter());
    }

    /**
     * Tests area calculation of a trapezoid.
     */
    @Test
    public void calculateAreaSuccess() {
        Trapezoid trapezoid = new Trapezoid(4,6,2);
        assertEquals(10, trapezoid.area());
    }
}
