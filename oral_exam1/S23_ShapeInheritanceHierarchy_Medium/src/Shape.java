/*
 * Name: Matthew Wipfler
 * Date: 9/16/17
 * File: Shape.java
 */

import com.sun.javafx.geom.Vec3d;

import java.awt.*;

/**
 * Base class for all shapes to derive from. Provides basic information
 * @author Matt Wipfler
 */
public abstract class Shape {
    //todo: add private member for subclass reference

    //region Private Members
    /** Name to identify shape by*/
    private String name;

    /**GUI- color of shape outline*/
    private Color outlineColor;
    /**GUI- rotation of object in space. Units in radians*/
    private Vec3d rotation; // in radians
    /**GUI- location of object in space. No default unit*/
    private Vec3d location;
    //endregion

    //region Accessors
    /** Accessor for name*/
    public String getName(){
        return name;
    }
    /** Accessor for name*/
    public void setName(String name){
        if(name != null)
            this.name = name;
    }

    /** Accessor for outlineColor*/
    public Color getColor() {return outlineColor;}
    /** Accessor for outlineColor*/
    public void setColor(Color color) {
        if(color != null)
            this.outlineColor = color;
    }

    /** Accessor for rotation*/
    public Vec3d getRotation() {
        return rotation;
    }
    /** Accessor for rotation*/
    public void setRotation(Vec3d rotation) {
        if(rotation != null)
            this.rotation = rotation;
    }

    /** Accessor for location*/
    public Vec3d getLocation() {
        return location;
    }
    /** Accessor for location*/
    public void setLocation(Vec3d location) {
        if(location != null)
            this.location = location;
    }
    //endregion

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     */
    public Shape(String name){
        this.name = name;

        this.outlineColor = Color.black;
        this.rotation = new Vec3d(0,0,0);
        this.location = new Vec3d(0,0,0);
    }
}
