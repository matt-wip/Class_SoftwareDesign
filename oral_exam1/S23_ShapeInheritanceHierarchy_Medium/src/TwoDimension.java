/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: TwoDimension.java
 */

import java.awt.*;

/**
 * Base class for 2d shapes
 * @author Matt Wipfler
 */
public abstract class TwoDimension extends Shape {

    // Private member
    /** GUI- Color to fill shape with*/
    private Color backGroundColor;

    // Accessors
    /** Accessor*/
    public Color getBackGroundColor() {
        return backGroundColor;
    }
    /** Accessor to set color. Cannot be null*/
    public void setBackGroundColor(Color backGround) {
        if(backGround!=null){
            this.backGroundColor = backGround;
        }
    }

    // Constructors
    /**
     * Constructor
     * @param name Name of Shape
     * @param backGroundColor Fill color
     */
    public TwoDimension(String name, Color backGroundColor){
        super(name);
        this.backGroundColor = backGroundColor;
    }
    public TwoDimension(String name){
        this(name,Color.white);
    }

    // Abstract class methods
    /** Abstract method for obtaining shape's area*/
    public abstract double getArea();
    /** Abstract method for obtaining shape's perimeter*/
    public abstract double getPerimeter();

    @Override
    /** Formats and returns generic info about shape*/
    public String toString(){
        String message = String.format("Info for object %s: \n", this.getName());
        message += "Area: " + this.getArea() + "\n";
        message += "Perimeter: " + this.getPerimeter();
        return  message;
    }
}
