/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Triangle.java
 */

import java.security.InvalidParameterException;

/**
 * Triangle uses a Side-Angle-Side implementation
 */
public abstract class Triangle extends TwoDimension {

    // Private members
    private double sideLengthA;
    private double sideLengthB;
    private double angleC; // angle (rad) formed by sideA and sideB

    // Constructor
    public Triangle(String name, double sideLengthA, double sideLengthB, double angleC){
        super(name);
        this.setAngleC(angleC);
        this.setSideLengthA(sideLengthA);
        this.setSideLengthB(sideLengthB);
    }

    // Accessors
    public void setSideLengthA(double length){
        if(length > 0){
            this.sideLengthA = length;
        }
        else{
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    public void setSideLengthB(double length){
        if(length > 0){
            this.sideLengthB = length;
        }
        else{
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

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
    public double getArea() {
        return (this.sideLengthA * this.sideLengthB * Math.sin(this.angleC))/2.0;
    }

    @Override
    public double getPerimeter() {
        double unknownSideLength = Math.pow(this.sideLengthA,2)+Math.pow(this.sideLengthB,2) - (2.0*this.sideLengthB*this.sideLengthA*Math.cos(this.angleC));
        unknownSideLength = Math.sqrt(unknownSideLength);
        return this.sideLengthA + this.sideLengthB + unknownSideLength;
    }

}
