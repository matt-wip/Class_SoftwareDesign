/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RegularPolygon.java
 */

/**
 * Class for creating and getting information of any regular polygon
 * @author Matt Wipfler
 */
public class RegularPolygon extends TwoDimension {

    // Private members
    /** Number of sides on the polygon*/
    private int sideCount;
    /** length of each side*/
    private double sideLength;

    // Constructor

    /**
     * Constructor
     * @param name Name of Shape
     * @param sideCount Number of sides
     * @param sideLength Length of each side
     */
    public RegularPolygon(String name, int sideCount, double sideLength){
        super(name);

       this.setSideCount(sideCount);
       this.setSideLength(sideLength);
    }

    // Accessors
    /** Accessor for side count*/
    public int getSideCount() {
        return sideCount;
    }

    /**
     * Accessor to set Side count
     * @param sideCount Desired number of sides,
     */
    public void setSideCount(int sideCount) {
        if(sideCount >= 3){
            this.sideCount = sideCount;
        }else{
            throw new IllegalArgumentException("Polygon must have at least 3 sides");
        }
    }

    /** Accessor for side length*/
    public double getSideLength() {
        return sideLength;
    }

    /**
     * Accessor to set length
     * @param sideLength Distance on one side
     */
    public void setSideLength(double sideLength) {
        if(sideLength > 0) {
            this.sideLength = sideLength;
        }else{
            throw new IllegalArgumentException("Side length must be greater than 0");
        }
    }


    @Override
    /**
     * Implementation of abstract class 2D. Calculates area of regular polygon
     */
    public double getArea() {
        return 0.5 * this.getApothem() * this.getPerimeter();
    }

    @Override
    /**
     * Implementation of abstract class 2D. Calculates perimeter of regular polygon.
     */
    public double getPerimeter(){
        return (double)this.sideCount * this.sideLength;
    }

    /**
     * Calculates the apothem of a regular polygon (center to center of a side)
     * @return length of apothem
     */
    public double getApothem(){
        return (this.sideLength / (2.0 * Math.tan(Math.PI / (double)this.sideCount)));
    }
}
