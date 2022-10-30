package org.example.trihards.geometry2d;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(8, 2);
        assertEquals(20, rectangle.perimeter());
    }

    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle(4, 4);
        assertEquals(16, rectangle.area());
    }
}