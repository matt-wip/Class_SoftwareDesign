/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Square.java
 */

import java.security.InvalidParameterException;

public class Square extends Rectangle {

    public Square(String name, double sideLength){
        super(name,sideLength,sideLength);
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
