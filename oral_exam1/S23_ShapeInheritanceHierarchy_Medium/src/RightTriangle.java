/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RightTriangle.java
 */

/**
 * Class for creating right triangle. Angle is set to pi/2 radians
 * @author Matt Wipfler
 */
public class RightTriangle extends Triangle{

    /**
     * Constructor
     * @param name Name of Shape
     * @param sideALength Length of right triangle leg
     * @param sideBLength Length of other leg
     */
    public RightTriangle(String name, double sideALength, double sideBLength){
        super(name,sideALength,sideBLength,Math.PI/2.0);
    }

    @Override
    /** Overrides Triangles method for setting the angle between legs. Can only be pi/2 radians*/
    public void setAngleC(double angle){
        if(angle != Math.PI/2.0){
            throw new IllegalArgumentException("Right angle triangle has constant pi/2 angle");
        }else{
            super.setAngleC(angle);
        }
    }
}
