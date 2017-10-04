/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Line.java
 */

import com.sun.javafx.geom.Vec3d;

public class Line extends OneDimension {

    // Constructor
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
        vEndCoord.y = vInitialCoord.y + Math.cos(vInitialRot.y) * this.getLength();
        vEndCoord.z = vInitialCoord.z + Math.cos(vInitialRot.z) * this.getLength();

        return vEndCoord;
    }
}
