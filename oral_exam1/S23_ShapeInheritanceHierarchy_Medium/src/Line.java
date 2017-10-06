/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Line.java
 */

import com.sun.javafx.geom.Vec3d;

/**
 * Line class for creating and manipulating a line
 * @author Matt Wipfler
 */
public class Line extends OneDimension {

    /** length of straight line*/
    private double length;

    @Override
    /**
     * Implementation of abstract 1D class.
     * Returns length of 1D object
     */
    public double getLength() {
        return this.length;
    }

    @Override
    /**
     * Implementation of abstract 1D class.
     * Sets length of 1D object
     */
    public void setLength(double length) {
        this.length = length;
    }

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     * @param length lenght of line (unitless)
     */
    public Line(String name, double length){
        super(name);
        this.setLength(length);
    }

    /**
     * Calculates the end point of a line based on coordinates, length, and rotation
     * @return Location of line end
     */
    public Vec3d getLineEndCoordinates(){
        Vec3d vEndCoord = new Vec3d(0,0,0);
        Vec3d vInitialCoord = this.getLocation();
        Vec3d vInitialRot = this.getRotation();

        vEndCoord.x = vInitialCoord.x + Math.cos(vInitialRot.x) * this.getLength();
        vEndCoord.y = vInitialCoord.y + Math.sin(vInitialRot.x) * this.getLength();
        vEndCoord.z = vInitialCoord.z + Math.sin(vInitialRot.y) * this.getLength();

        return vEndCoord;
    }
}
