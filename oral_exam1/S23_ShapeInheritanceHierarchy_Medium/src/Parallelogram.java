/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Parallelogram.java
 */

/**
 * Abstaract class for Parallelograms. Similar behavior
 * and equations are shared
 * @author Matt Wipfler
 */
public abstract class Parallelogram extends TwoDimension {

    // Private members
    /** One side length*/
    private double sideALength;
    /** A side length adjacent to sideA*/
    private double sideBLength;

    // Constructor

    /**
     * Constructor
     * @param name Name of Shape
     * @param aLength Length of a side
     * @param bLength Length of an adjacent side
     */
    public Parallelogram(String name, double aLength, double bLength){
        super(name);

        this.setSideALength(aLength);
        this.setSideBLength(bLength);
    }

    // Accessors
    /** Accessor- Gets sideA length*/
    public double getSideALength(){return this.sideALength;}
    /** Accessor - sets sideA length if greater than 0*/
    public void setSideALength(double length){
        if(length > 0){
            this.sideALength = length;
        }else {
            throw new IllegalArgumentException("Length can not be less than 0");
        }
    }
    /** Accessor- Gets sideB length*/
    public double getSideBLength(){return this.sideBLength;}
    /** Accessor - sets sideA length if greater than 0*/
    public void setSideBLength(double length){
        if(length > 0){
            this.sideBLength = length;
        }else {
            throw new IllegalArgumentException("Length can not be less than 0");
        }
    }

    @Override
    /**
     * Defines behavior for obtaining perimeter. All parallelograms share the same equation.
     */
    public double getPerimeter() {
        return 2.0 * this.sideBLength + 2.0 * this.sideALength;
    }
}
