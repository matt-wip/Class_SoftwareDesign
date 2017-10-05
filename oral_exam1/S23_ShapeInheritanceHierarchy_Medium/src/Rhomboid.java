/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Rhomboid.java
 */

import java.security.InvalidParameterException;

public class Rhomboid extends Parallelogram {

    // Private member
    private double interiorAngle; // Angle formed by sideA and sideB in radians

    // Constructor
    public Rhomboid(String name, double sideALength, double sideBLength, double interiorAngle){
        super(name,sideALength,sideBLength);
        this.setInteriorAngle(interiorAngle);
    }

    // Accessors
    public double getInteriorAngle(){return this.interiorAngle;}
    public void setInteriorAngle(double angle){
        if(angle > 0 && angle <= Math.PI){
            this.interiorAngle = angle;
        }
        else{
            this.interiorAngle = Math.PI;
            throw new InvalidParameterException("Angle must be between 0 and PI radians");
        }
    }

    @Override
    public double getArea(){
        return this.getSideALength() * this.getSideBLength() * Math.sin(this.interiorAngle);
    }
}
