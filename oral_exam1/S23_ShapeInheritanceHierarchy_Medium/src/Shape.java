/*
 * Name: Matthew Wipfler
 * Date: 9/16/17
 * File: Shape.java
 */

import com.sun.javafx.geom.Vec3d;

import java.awt.*;

/**
 * Base class for all shapes to derive from
 */
public class Shape {

    //region Private Members
    private String name;
    private Color outlineColor;
    private Vec3d rotation; // in radians
    private Vec3d location;
    //endregion

    //region Accessors
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name != null)
            this.name = name;
    }

    public Color getColor() {
        return outlineColor;
    }
    public void setColor(Color color) {
        if(color != null)
            this.outlineColor = color;
    }

    public Vec3d getRotation() {
        return rotation;
    }
    public void setRotation(Vec3d rotation) {
        if(rotation != null)
            this.rotation = rotation;
    }

    public Vec3d getLocation() {
        return location;
    }
    public void setLocation(Vec3d location) {
        if(location != null)
            this.location = location;
    }
    //endregion

    // Constructor
    public Shape(){
        this("");
    }

    // Constructor
    public Shape(String name){
        this.name = name;

        this.outlineColor = Color.black;
        this.rotation = new Vec3d(0,0,0);
        this.location = new Vec3d(0,0,0);
    }
}
