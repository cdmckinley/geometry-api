package org.example.trihards.geometry2d;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for the Parallelogram class.
 */
public class ParallelogramTest {

    /**
     * Tests perimeter.
     */
    @Test
    public void testPerimeter() {
        Parallelogram parallelogram = new Parallelogram(8, 2);
        assertEquals(20, parallelogram.perimeter());
    }

    /**
     * Tests area.
     */
    @Test
    public void testArea() {
        Parallelogram parallelogram = new Parallelogram(4, 4);
        assertEquals(16, parallelogram.area());
    }
}