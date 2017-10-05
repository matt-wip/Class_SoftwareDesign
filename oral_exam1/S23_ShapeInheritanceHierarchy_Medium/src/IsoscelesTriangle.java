/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: IsoscelesTriangle.java
 */


public class IsoscelesTriangle extends Triangle{

    public IsoscelesTriangle(String name, double sameSideLength, double angle) {
        super(name, sameSideLength, sameSideLength, angle);
    }

    @Override
    public void setSideLengthA(double length){
        if(length > 0) {
            super.setSideLengthA(length);
            super.setSideLengthB(length);
        }
        else{
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    @Override
    public void setSideLengthB(double length){
        this.setSideLengthA(length);
    }
}
