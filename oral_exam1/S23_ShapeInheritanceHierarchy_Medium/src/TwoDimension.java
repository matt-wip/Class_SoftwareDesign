/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: TwoDimension.java
 */

import java.awt.*;

/** Base class for 2d shapes */
public abstract class TwoDimension extends Shape {

    // Private member
    private Color backGroundColor;

    // Accessors
    public Color getBackGroundColor() {
        return backGroundColor;
    }
    public void setBackGroundColor(Color backGround) {
        if(backGround!=null){
            this.backGroundColor = backGround;
        }
    }

    // Constructors
    public TwoDimension(String name, Color backGroundColor){
        super(name);
        this.backGroundColor = backGroundColor;
    }
    public TwoDimension(String name){
        this(name,Color.white);
    }
    public TwoDimension(){
        this("");
    }

    // Abstract class methods
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString(){
        String message = String.format("Info for object %s: \n", this.getName());
        message += "Area: " + this.getArea() + "\n";
        message += "Perimeter: " + this.getPerimeter();
        return  message;
    }
}
