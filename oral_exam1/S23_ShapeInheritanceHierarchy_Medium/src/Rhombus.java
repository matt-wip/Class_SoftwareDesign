/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Rhombus.java
 */

import java.security.InvalidParameterException;

public class Rhombus extends  Rhomboid{

    // Constructor
    public Rhombus(String name, double sideLength, double interiorAngle) {
        super(name, sideLength, sideLength, interiorAngle);
    }

    @Override
    public void setSideALength(double length) {
        if(length > 0){
            super.setSideALength(length);
            super.setSideBLength(length);
        }else {
            throw new InvalidParameterException("Length can not be less than 0");
        }
    }

    @Override
    public void setSideBLength(double length){
        this.setSideALength(length);
    }
}
