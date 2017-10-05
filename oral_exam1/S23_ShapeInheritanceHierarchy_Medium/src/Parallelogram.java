/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Parallelogram.java
 */

import java.security.InvalidParameterException;

public abstract class Parallelogram extends TwoDimension {

    // Private members
    private double sideALength;
    private double sideBLength;

    // Constructor
    public Parallelogram(String name, double aLength, double bLength){
        super(name);

        this.setSideALength(aLength);
        this.setSideBLength(bLength);
    }

    // Accessors
    public double getSideALength(){return this.sideALength;}
    public void setSideALength(double length){
        if(length > 0){
            this.sideALength = length;
        }else {
            throw new IllegalArgumentException("Length can not be less than 0");
        }
    }

    public double getSideBLength(){return this.sideBLength;}
    public void setSideBLength(double length){
        if(length > 0){
            this.sideBLength = length;
        }else {
            throw new IllegalArgumentException("Length can not be less than 0");
        }
    }

    @Override
    public double getPerimeter() {
        return 2.0 * this.sideBLength + 2.0 * this.sideALength;
    }
}
