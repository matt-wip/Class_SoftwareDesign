/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Rectangle.java
 */

/**
 * Rectangle class deriving from Paralelogram
 */
public class Rectangle extends Parallelogram {

    /**
     * Constructor
     * @param name Name of Shape
     * @param sideALength   Length of a side
     * @param sideBLength   Length of an adjacent side
     */
    public Rectangle(String name, double sideALength, double sideBLength){
        super(name,sideALength,sideBLength);
    }

    @Override
    /**
     * Area definition for this shape
     */
    public double getArea() {
        return this.getSideALength() * this.getSideBLength();
    }
}
