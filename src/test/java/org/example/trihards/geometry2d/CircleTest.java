package org.example.trihards.geometry2d;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for Circle class.
 */
public class CircleTest {

    /**
     * Tests perimeter calculation of a circle.
     */
    @Test
    public void calculatePerimeterSuccess() {
        Circle circle = new Circle(4);
        assertEquals(25.132741228718345907701147066236, circle.perimeter());
    }

    /**
     * Tests area calculation of a circle.
     */
    @Test
    public void calculateAreaSuccess() {
        Circle circle = new Circle(4);
        assertEquals(50.265482457436691815402294132472, circle.area());
    }
}
