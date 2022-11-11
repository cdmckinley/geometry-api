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
import java.util.HashSet;
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

    static final String PERIMETER = "perimeter";

    static final String AREA = "area";

    static final String ERROR_WRONG_NUMBER_OF_MEASUREMENTS = "The shape name and number of measurements don't match. Please check the documentation to see what data each shape expects.";

    /**
     * Instantiates the service, and populates the list of supported shapes.
     */
    public Geometry2d() {
        supportedShapesList.add("circle");
        supportedShapesList.add("triangle");
        supportedShapesList.add("parallelogram");
        supportedShapesList.add("rectangle");
        supportedShapesList.add("square");
        supportedShapesList.add("trapezoid");
    }

    /**
     * Gets a response, either an error, help message, or solution.
     *
     * @param shapeName         the name of the shape to instantiate
     * @param formulaType       the formula to find the solution to (perimeter or area)
     * @param measurementsInput the measurements of the shape
     * @return the solution, list of supported shapes, or error message
     */
    @Path("/{shape}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse(@PathParam("shape") String shapeName, @QueryParam("formula") String formulaType,
                                @QueryParam("measurements") String measurementsInput) {
        ObjectMapper mapper = new ObjectMapper();
        Object responseObject;

        if (shapeName.equals("help") || shapeName.equals("options")) {
            responseObject = supportedShapesList;
        } else {
            double[] measurements;
            if (measurementsInput != null && !measurementsInput.isBlank()) {
                try {
                    measurements = mapper.readValue(measurementsInput, double[].class);
                } catch (JsonProcessingException jpe) {
                    logger.error("Could not read measurements", jpe);
                    responseObject = "The measurements could not be read. Please use a JSON array of numbers.";
                }
            }
            if (measurements != null) {
                switch (shapeName) {
                    case "parallelogram":
                        responseObject = parallelogram(formulaType, measurements);
                        break;
                    case "triangle":
                        responseObject = triangle(formulaType, measurements);
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
     * Determines if a shape is supported
     *
     * @param shapeName the name of the desired shape
     * @return true if the shape is a supported shape, otherwise false
     */
    protected boolean shapeIsSupported(String shapeName) {
        for (String shape : supportedShapesList){
            if (shape.equals(shapeName.toLowerCase())) return true;
        }
        return false;
    }

    protected boolean hasAmountOfMeasurements(double[] measurements, int expectedLength) {
        if (measurements != null && measurements.length == expectedLength) return true;
        return false;
    }

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

    protected Object parallelogram(String formulaType, double[] measurements) {
        if (hasAmountOfMeasurements(measurements, 2)) {
            Shape shape = new Parallelogram(measurements[0], measurements[1]);
            return processResponse(shape, formulaType);
        } else return ERROR_WRONG_NUMBER_OF_MEASUREMENTS;
    }

    protected Object triangle(String formulaType, double[] measurements) {
        if (hasAmountOfMeasurements(measurements, 3) && formulaType.equals("perimeter")) {
            Shape shape = new Triangle(measurements[0], measurements[1], measurements[2]);
            return processResponse(shape, formulaType);
        } else if (hasAmountOfMeasurements(measurements, 2) && formulaType.equals("area")) {
            Shape shape = new Triangle(measurements[0], measurements[1]);
            return processResponse(shape, formulaType);
        } else return ERROR_WRONG_NUMBER_OF_MEASUREMENTS;
    }
}
