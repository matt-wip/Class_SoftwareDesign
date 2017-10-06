/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Circle.java
 */

/**
 * Class for a 2D circle object. Subclass of Oval
 */
public class Circle extends Oval{

    /**
     *  Constructor
     * @param name circle's name
     * @param radius radius of the object
     */
    public Circle(String name, double radius){
        super(name, radius, radius);
    }

    @Override
    /**
     * Accessor to adjust a radius
     * Circle's minor and major axis should be the one
     */
    public void setMajorAxis(double majorAxis) {
        super.setMinorAxis(majorAxis);
        super.setMajorAxis(majorAxis);
    }

    @Override
    /**
     * Accessor to adjust a radius
     * Circle's minor and major axis should be the one
     */
    public void setMinorAxis(double minorAxis){
        this.setMajorAxis(minorAxis);
    }
}
