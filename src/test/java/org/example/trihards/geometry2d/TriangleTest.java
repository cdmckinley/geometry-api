package org.example.trihards.geometry2d;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for Triangle class.
 */
public class TriangleTest {

    /**
     * Tests perimeter calculation of a triangle.
     */
    @Test
    public void calculatePerimeterSuccess() {
        Triangle triangle = new Triangle(7,8,9);
        assertEquals(24, triangle.perimeter());
    }

    /**
     * Tests area calculation of a triangle.
     */
    @Test
    public void calculateAreaSuccess() {
        Triangle triangle = new Triangle(7,4);
        assertEquals(14, triangle.area());
    }
}
