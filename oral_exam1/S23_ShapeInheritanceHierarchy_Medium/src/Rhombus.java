/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Rhombus.java
 */

import java.security.InvalidParameterException;

/**
 * Class for creating a rhombus
 * @author Matt Wipfler
 */
public class Rhombus extends  Rhomboid{

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     * @param sideLength Length of a rhombus side
     * @param interiorAngle Angle formed from two sides
     */
    public Rhombus(String name, double sideLength, double interiorAngle) {
        super(name, sideLength, sideLength, interiorAngle);
    }

    @Override
    /** Overrides Rhomboid side length accessor. Rhombus sides must be the same length*/
    public void setSideALength(double length) {
        if(length > 0){
            super.setSideALength(length);
            super.setSideBLength(length);
        }else {
            throw new InvalidParameterException("Length can not be less than 0");
        }
    }

    @Override
    /** Overrides Rhomboid side length accessor. Rhombus sides must be the same length*/
    public void setSideBLength(double length){
        this.setSideALength(length);
    }
}
