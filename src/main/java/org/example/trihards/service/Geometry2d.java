package org.example.trihards.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.trihards.geometry2d.*;
import org.example.trihards.response.Response2d;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A service working with 2d geometry.
 */
@Path("/2d")
public class Geometry2d {
    /**
     * The logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The list of supported shapes.
     */
    protected Set<String> supportedShapesList = new HashSet<>();

    /**
     * The Perimeter.
     */
    static final String PERIMETER = "perimeter";

    /**
     * The Area.
     */
    static final String AREA = "area";

    /**
     * The Error wrong number of measurements.
     */
    static final String ERROR_WRONG_NUMBER_OF_MEASUREMENTS = "The shape name and number of measurements don't match. Please check the documentation to see what data each shape expects.";

    /**
     * The Error unsupported formula.
     */
    static final String ERROR_UNSUPPORTED_FORMULA = "The formula you're looking for is not supported. Please check the documentation to see what formulas we support.";

    /**
     * Instantiates the service, and populates the list of supported shapes.
     */
    public Geometry2d() {
        supportedShapesList.add("circle");
        supportedShapesList.add("triangle");
        supportedShapesList.add("parallelogram");
        supportedShapesList.add("trapezoid");
    }

    /**
     * Gets a response, either an error, help message, or solution.
     *
     * @param shapeName          the name of the shape to instantiate
     * @param formulaType        the formula to find the solution to (perimeter or area)
     * @param measurementsInputs the measurements of the shape
     * @return the solution, list of supported shapes, or error message
     */
    @Path("/{shape}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse(@PathParam("shape") String shapeName, @QueryParam("formula") String formulaType,
                                @QueryParam("measurements") List<String> measurementsInputs) {
        ObjectMapper mapper = new ObjectMapper();
        Object responseObject = null;

        if (shapeName.equals("help") || shapeName.equals("options")) {
            responseObject = supportedShapesList;
        } else {
            List<Double> measurements = new ArrayList<>();
            if (measurementsInputs != null) {
                try {
                    for (String measurementsInput : measurementsInputs) {
                        String[] measurementStrings = measurementsInput.split(",");
                        for (String measurementString : measurementStrings) {
                            measurements.add(Double.parseDouble(measurementString));
                        }
                    }
                } catch (NumberFormatException nfe) {
                    logger.error("There was a problem with the format of the measurements input.", nfe);
                    measurements = null;
                } catch (NullPointerException npe) {
                    logger.error("There was a null measurement provided.", npe);
                    measurements = null;
                }
            }
            if (measurements != null && !measurements.isEmpty()) {
                switch (shapeName) {
                    case "parallelogram":
                        responseObject = parallelogram(formulaType, measurements);
                        break;
                    case "triangle":
                        responseObject = triangle(formulaType, measurements);
                        break;
                    case "circle":
                        responseObject = circle(formulaType, measurements);
                        break;
                    case "trapezoid":
                        responseObject = trapezoid(formulaType, measurements);
                        break;
                    default:
                        responseObject = "Shape '" + shapeName +
                                "' is not supported. Pass 'help' or 'options' as a shape to see a list of supported shapes.";
                }
            }
        }
        if (responseObject != null) {
            int statusCode;
            if (responseObject instanceof Response2d) statusCode = 200;
            else if (responseObject instanceof String) statusCode = 400;
            else statusCode = 500;
            String responseJson;
            try {
                responseJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseObject);
                return Response.status(statusCode).entity(responseJson).build();
            } catch (JsonProcessingException jpe) {
                logger.error(jpe);
            }
        }
        String errorMessage = "Something went wrong in the process.";
        return Response.status(500).entity(errorMessage).build();
    }

    /**
     * Returns true if a measurements List has an amount of elements.
     *
     * @param measurements the measurements List
     * @param expectedSize the expected size
     * @return True if the measurements List has the expected number of elements.
     */
    protected boolean hasAmountOfMeasurements(List<Double> measurements, int expectedSize) {
        if (measurements != null && measurements.size() == expectedSize) return true;
        return false;
    }

    /**
     * Generates JSON from a Shape and 'formulaType' query parameter.
     *
     * @param shape       the shape
     * @param formulaType the formula type
     * @return the JSON object, or a JSON String error message if a formula type isn't supported.
     */
    protected Object processResponse(Shape shape, String formulaType) {
        Response2d response2d = new Response2d();
        if (formulaType != null && formulaType.equals(PERIMETER)) {
            response2d.setPerimeter(shape);
        } else if (formulaType != null && formulaType.equals(AREA)) {
            response2d.setArea(shape);
        } else if (formulaType == null || formulaType.isBlank()) {
            response2d.setPerimeter(shape);
            response2d.setArea(shape);
        } else {
            return "Formula '" + formulaType +
                    "' is not supported. Please try 'area', 'perimeter', or leaving the formula out of the query";
        }
        return response2d;
    }

    /**
     * Instantiates a Parallelogram from a height and width, then processes the JSON.
     *
     * @param formulaType  the formula type
     * @param measurements the measurements of the Shape
     * @return the JSON or an error message
     */
    protected Object parallelogram(String formulaType, List<Double> measurements) {
        if (hasAmountOfMeasurements(measurements, 2)) {
            Shape shape = new Parallelogram(measurements.get(0), measurements.get(1));
            return processResponse(shape, formulaType);
        } else return ERROR_WRONG_NUMBER_OF_MEASUREMENTS;
    }

    /**
     * Instantiates a Triangle from 3 sides for perimeter, or a height and width for area, then processes the JSON.
     *
     * @param formulaType  the formula type
     * @param measurements the measurements of the Shape
     * @return the JSON or an error message
     */
    protected Object triangle(String formulaType, List<Double> measurements) {
        if (hasAmountOfMeasurements(measurements, 3) && formulaType.equals(PERIMETER)) {
            Shape shape = new Triangle(measurements.get(0), measurements.get(1), measurements.get(2));
            return processResponse(shape, formulaType);
        } else if (hasAmountOfMeasurements(measurements, 2) && formulaType.equals(AREA)) {
            Shape shape = new Triangle(measurements.get(0), measurements.get(1));
            return processResponse(shape, formulaType);
        } else if (formulaType.equals(PERIMETER) || formulaType.equals(AREA)) {
            return ERROR_WRONG_NUMBER_OF_MEASUREMENTS;
        } else return ERROR_UNSUPPORTED_FORMULA;
    }

    /**
     * Instantiates a Circle from a radius, then processes the JSON.
     *
     * @param formulaType  the formula type
     * @param measurements the measurements of the Shape
     * @return the JSON or an error message
     */
    protected Object circle(String formulaType, List<Double> measurements) {
        if (hasAmountOfMeasurements(measurements, 1)) {
            Shape shape = new Circle(measurements.get(0));
            return processResponse(shape, formulaType);
        } else return ERROR_WRONG_NUMBER_OF_MEASUREMENTS;
    }

    /**
     * Instantiates a Trapezoid from 4 sides for a perimeter, or 2 parallel bases and a height, then processes the JSON.
     *
     * @param formulaType  the formula type
     * @param measurements the measurements of the Shape
     * @return the JSON or an error message
     */
    protected Object trapezoid(String formulaType, List<Double> measurements) {
        if (hasAmountOfMeasurements(measurements, 4) && formulaType.equals(PERIMETER)) {
            Shape shape = new Trapezoid(measurements.get(0), measurements.get(1), measurements.get(2),
                    measurements.get(3));
            return processResponse(shape, formulaType);
        } else if (hasAmountOfMeasurements(measurements, 3) && formulaType.equals(AREA)) {
            Shape shape = new Trapezoid(measurements.get(0), measurements.get(1), measurements.get(2));
            return processResponse(shape, formulaType);
        } else if (formulaType.equals(PERIMETER) || formulaType.equals(AREA)) {
            return ERROR_WRONG_NUMBER_OF_MEASUREMENTS;
        } else return ERROR_UNSUPPORTED_FORMULA;
    }
}
