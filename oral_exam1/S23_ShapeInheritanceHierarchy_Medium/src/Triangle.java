/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Triangle.java
 */

import java.security.InvalidParameterException;

/**
 * Abstract class for triangle creation
 * Triangle uses a Side-Angle-Side implementation
 * @author Matt Wipfler
 */
public abstract class Triangle extends TwoDimension {

    // Private members
    /** Length of a triangle side*/
    private double sideLengthA;
    /** Length of another side*/
    private double sideLengthB;
    /** Angle formed by the two sides (rad)*/
    private double angleC;

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     * @param sideLengthA Length of a side
     * @param sideLengthB Length of another side
     * @param angleC Angle formed between sides
     */
    public Triangle(String name, double sideLengthA, double sideLengthB, double angleC){
        super(name);

        this.setAngleC(angleC);
        this.setSideLengthA(sideLengthA);
        this.setSideLengthB(sideLengthB);
    }

    // Accessors
    /** Accessor*/
    public double getSideLengthA(){return this.sideLengthA;}
    /** Accessor to set side length. Must be greater than 0*/
    public void setSideLengthA(double length){
        if(length > 0){
            this.sideLengthA = length;
        }
        else{
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    /** Accessor*/
    public double getSideLengthB(){return this.sideLengthB;}
    /** Accessor to set side length. Must be greater than 0*/
    public void setSideLengthB(double length){
        if(length > 0){
            this.sideLengthB = length;
        }
        else{
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    /**
     * Accessor to set angle between sides
     * @param angle Desired angle in radians. Must be between 0 and PI
     */
    public void setAngleC(double angle){
        if(angle > 0 && angle < Math.PI){
            this.angleC = angle;
        }
        else{
            throw new IllegalArgumentException("Angle must be between 0 and PI");
        }
    }

    //
    @Override
    /** Implementation of abstract class 2D. All triangles use the same equation for area*/
    public double getArea() {
        return (this.sideLengthA * this.sideLengthB * Math.sin(this.angleC)) / 2.0;
    }

    @Override
    /** Implementation of abstract class 2D. All triangles use the same equation for perimeter*/
    public double getPerimeter() {
        double unknownSideLength = Math.pow(this.sideLengthA,2) + Math.pow(this.sideLengthB,2) - (2.0*this.sideLengthB*this.sideLengthA*Math.cos(this.angleC));
        unknownSideLength = Math.sqrt(unknownSideLength);
        return this.sideLengthA + this.sideLengthB + unknownSideLength;
    }

}
