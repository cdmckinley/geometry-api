package org.example.trihards.application;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.trihards.service.Geometry2d;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The Geometry web application.
 */
@ApplicationPath("/services")
public class GeometryApplication extends Application {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets the services to be used in the application
     * @return a Set of services
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> hashset = new HashSet<>();
        hashset.add(Geometry2d.class);
        return hashset;
    }
}
