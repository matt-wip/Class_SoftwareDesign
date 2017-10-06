/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: IsoscelesTriangle.java
 */


/**
 * Isosceles Triangle subclass
 * @author Matt Wipfler
 */
public class IsoscelesTriangle extends Triangle{

    /**
     * Constructor
     * @param name  Name of Shape
     * @param sameSideLength Lenght of sides in SAS triangle
     * @param angle Angle formed by the two sides
     */
    public IsoscelesTriangle(String name, double sameSideLength, double angle) {
        super(name, sameSideLength, sameSideLength, angle);
    }

    @Override
    /**
     * Isosceles triangle sides should stay the same. Override standard triangle accessor
     */
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
    /**
     * Isosceles triangle sides should stay the same. Override standard triangle accessor
     */
    public void setSideLengthB(double length){
        this.setSideLengthA(length);
    }
}
