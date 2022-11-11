package org.example.trihards.application;


import org.example.trihards.service.Geometry2d;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class GeometryApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet hashset =new HashSet<Class<?>>();
        hashset.add(Geometry2d.class);
        return hashset;
    }
}
