/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Square.java
 */

import java.security.InvalidParameterException;

/**
 * Class for creating a square
 * @author Matt Wipfler
 */
public class Square extends Rectangle {

    /**
     * Constructor
     * @param name Name of Shape
     * @param sideLength Length of a side
     */
    public Square(String name, double sideLength){
        super(name,sideLength,sideLength);
    }

    @Override
    /** Overrides Rectangle accessor. Square lengths must be the same size*/
    public void setSideALength(double length) {
        if(length > 0){
            super.setSideALength(length);
            super.setSideBLength(length);
        }else {
            throw new IllegalArgumentException("Length can not be less than 0");
        }
    }

    @Override
    /** Overrides Rectangle accessor. Square lengths must be the same size*/
    public void setSideBLength(double length){
        this.setSideALength(length);
    }
}
