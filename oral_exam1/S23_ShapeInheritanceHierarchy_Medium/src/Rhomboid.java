/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Rhomboid.java
 */

/**
 * Class for creating a rhomboid.
 * @author Matt Wipfler
 */
public class Rhomboid extends Parallelogram {

    // Private member
    /** Angle formed by sideA and sideB in radians*/
    private double interiorAngle;

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     * @param sideALength Length of a side
     * @param sideBLength Length of an adjacent side
     * @param interiorAngle Angle formed by the two sides
     */
    public Rhomboid(String name, double sideALength, double sideBLength, double interiorAngle){
        super(name,sideALength,sideBLength);
        this.setInteriorAngle(interiorAngle);
    }

    // Accessors
    /** Accessor for getting interiorAngle*/
    public double getInteriorAngle(){return this.interiorAngle;}
    /** Accessor for setting interiorAngle. Has to be between 0 and PI radians*/
    public void setInteriorAngle(double angle){
        if(angle > 0 && angle <= Math.PI){
            this.interiorAngle = angle;
        }
        else{
            this.interiorAngle = Math.PI/4.0;
            throw new IllegalArgumentException("Angle must be between 0 and PI radians");
        }
    }

    @Override
    /**
     * Implementation of abstract class 2D. Returns area of rhomboid
     */
    public double getArea(){
        return this.getSideALength() * this.getSideBLength() * Math.sin(this.interiorAngle);
    }
}
