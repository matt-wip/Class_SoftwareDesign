/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Oval.java
 */

public class Oval extends TwoDimension {

    // Private members
    private double majorAxis;
    private double minorAxis;

    // Accessors
    public double getMajorAxis() {
        return majorAxis;
    }
    public void setMajorAxis(double majorAxis) {
        this.majorAxis = Math.abs(majorAxis);
    }

    public double getMinorAxis() {
        return minorAxis;
    }
    public void setMinorAxis(double minorAxis) {
        this.minorAxis = Math.abs(minorAxis);
    }

    // Constructor
    public Oval(String name, double majorAxis, double minorAxis){
        super(name);

        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public double getArea() {
        return Math.PI * this.majorAxis * this.minorAxis;
    }

    @Override
    public double getPerimeter() {
        double h = Math.pow((this.majorAxis-this.minorAxis),2) / Math.pow((this.majorAxis+this.minorAxis),2);
        double ratio = (3.0*h)/(10+Math.sqrt(4-3.0*h));
        return Math.PI*(this.minorAxis+this.majorAxis)*(1+ratio);
    }
}
