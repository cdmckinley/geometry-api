package org.example.trihards.geometry2d;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO JavaDocs
// TODO If the result is different than expected by less than 0.01, we should probably replace the expected results in that case

public class CircleTest {

    @Test
    public void testPerimeter() {
        int radius = 4;
        // TODO create a circle with that radius
        assertEquals(25.132741228718345907701147066236, 0); // Replace th 0 with the instantiated shape's perimeter method
    }

    @Test
    public void testArea() {
        int radius = 4;
        // TODO create a circle with that radius
        assertEquals(50.265482457436691815402294132472, 0); // Replace th 0 with the instantiated shape's area method
    }
}
