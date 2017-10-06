/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RightTriangle.java
 */

/**
 * Class for creating scalene triangle. Nothing to override from triangle
 * @author Matt Wipfler
 */
public class ScaleneTriangle extends Triangle {

    /**
     * Constructor
     * @param name Name of Shape
     * @param sideLengthA Length of a side
     * @param sideLengthB Length of another side
     * @param angleC Angle formed between sides
     */
    public ScaleneTriangle(String name, double sideLengthA, double sideLengthB, double angleC) {
        super(name, sideLengthA, sideLengthB, angleC);
    }
}
