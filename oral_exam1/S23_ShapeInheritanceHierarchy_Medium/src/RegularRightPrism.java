/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RegularRightPrism.java
 */

/**
 * Class for creating a 3D prism where the faces are a regular polygon.
 * Faces are parallel and are centered over one another
 * NOTE: RegularRightPrism is obsolete. Use RightGenericPrism instead
 * @author Matt Wipfler
 * @see RightGenericPrism
 */
public class RegularRightPrism extends ThreeDimension{

    // Private members
    /** Shape of prism faces*/
    private RegularPolygon baseShape;
    /** Distance between faces*/
    private double height;

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     * @param baseShape Polygon face shape
     * @param height Distance between faces
     */
    public RegularRightPrism(String name, RegularPolygon baseShape, double height){
        super(name);

        this.setBaseShape(baseShape);
        this.setHeight(height);
    }

    // Accessors
    /** Accessor for height*/
    public double getHeight(){return this.height;}
    /** Accessor for height*/
    public void setHeight(double height){
        if(height > 0){
            this.height = height;
        }
        else{
            throw new IllegalArgumentException("Prism height is below 0");
        }
    }

    /** Accessor for face shape*/
    public RegularPolygon getBaseShape() {return baseShape;}
    /** Accessor for face shape*/
    public void setBaseShape(RegularPolygon shape){
        if(shape != null){
            this.baseShape = shape;
        }
        else{
            throw new IllegalArgumentException("Prism base is null");
        }
    }

    @Override
    /**
     * Implementation of abstract class 3D. Returns volume of prism
     */
    public double getVolume() {
        return this.baseShape.getArea() * this.height;
    }

    @Override
    /**
     * Implementation of abstract class 3D. Returns surface area of prism
     */
    public double getSurfaceArea() {
        double faceSA = 2.0 * this.baseShape.getArea();
        return faceSA + this.height * this.baseShape.getPerimeter();
    }
}
