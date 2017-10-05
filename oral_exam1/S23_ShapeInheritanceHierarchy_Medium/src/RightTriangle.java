/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RightTriangle.java
 */

public class RightTriangle extends Triangle{

    public RightTriangle(String name, double sideALength, double sideBLength){
        super(name,sideALength,sideBLength,Math.PI/2.0);
    }

    @Override
    public void setAngleC(double angle){
        if(angle != Math.PI/2.0){
            throw new IllegalArgumentException("Right angle triangle has constant pi/2 angle");
        }
    }
}
