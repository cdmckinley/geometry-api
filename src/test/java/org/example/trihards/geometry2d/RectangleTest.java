package org.example.trihards.geometry2d;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for the Rectangle class.
 */
public class RectangleTest {

    /**
     * Tests perimeter.
     */
    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(8, 2);
        assertEquals(20, rectangle.perimeter());
    }

    /**
     * Tests area.
     */
    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle(4, 4);
        assertEquals(16, rectangle.area());
    }
}