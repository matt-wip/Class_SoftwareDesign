/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: ThreeDimension.java
 */

/**
 * Class for creating a 3D pyramid. Base is a regular polygon.
 * Vertex of pyramid is over centroid of base
 * @author Matt Wipfler
 */
public class RegularRightPyramid extends ThreeDimension{

    // Private members
    /** Base shape for pyramid*/
    private RegularPolygon baseShape;
    /** Distance from base to vertex*/
    private double height;

    // Constructor

    /**
     * Constructor
     * @param name Name of Shape
     * @param baseShape Base shape
     * @param height Height of pyramid
     */
    public RegularRightPyramid(String name, RegularPolygon baseShape, double height){
        super(name);

        this.setBaseShape(baseShape);
        this.setHeight(height);
    }

    // Accessors
    /** Accessor for getting height*/
    public double getHeight(){return this.height;}
    /** Accessor for setting height*/
    public void setHeight(double height){
        if(height > 0){
            this.height = height;
        }
        else{
            throw new IllegalArgumentException("Pyramid height is below 0");
        }
    }

    /** Accessor for getting base shape*/
    public RegularPolygon getBaseShape() {return baseShape;}
    /** Accessor for setting base shape. Can not be null*/
    public void setBaseShape(RegularPolygon shape){
        if(shape != null){
            this.baseShape = shape;
        }
        else{
            throw new IllegalArgumentException("Pyramid base is null");
        }
    }

    @Override
    /** Implementation of abstract 3D class. Returns volume of pyramid*/
    public double getVolume() {
        return (1.0/3.0) * this.baseShape.getArea() * this.height;
    }

    @Override
    /** Implementation of abstract 3D class. Returns SA of pyramid*/
    public double getSurfaceArea() {
        double lateralSA = 0.5 * this.getSlantLength() * this.baseShape.getPerimeter();
        return lateralSA + this.baseShape.getArea();
    }

    /**
     * Calculates and returns slant length of pyramid
     * @return Distance from center of edge to vertex
     */
    public double getSlantLength(){
        double slantLength = Math.pow(this.baseShape.getApothem(),2) + Math.pow(this.height,2);
        slantLength = Math.sqrt(slantLength);
        return slantLength;
    }
}
