package org.example.trihards.response;

import org.example.trihards.geometry2d.Shape;

/**
 * The type for generating JSON responses for the Geometry2d service.
 */
public class Response2d {

    /**
     * The perimeter to return.
     */
    private Object perimeter;

    /**
     * The area to return.
     */
    private Object area;

    /**
     * Gets the perimeter.
     *
     * @return the perimeter
     */
    public Object getPerimeter() {
        return perimeter;
    }

    /**
     * Sets perimeter using a Shape.
     *
     * @param shape the shape to call the perimeter method
     */
    public void setPerimeter(Shape shape) {
        double perimeter = shape.perimeter();
        if (perimeter > 0.0) this.perimeter = perimeter;
    }

    /**
     * Gets the area.
     *
     * @return the area
     */
    public Object getArea() {
        return area;
    }

    /**
     * Sets area using a Shape.
     *
     * @param shape the shape to call the area method
     */
    public void setArea(Shape shape) {
        double area = shape.area();
        if (area > 0.0) this.area = area;
    }
}
