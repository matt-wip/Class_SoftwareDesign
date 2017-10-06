/*
        * Name: Matthew Wipfler
        * Date: 10/4/17
        * File: RightCylinder.java
        */

/**
 * Code for creating a right angle cylinder. Bases are parallel and have centroids lining up 90 degrees to faces
 * NOTE: Right Cylinder is obsolete. Use RightGenericPrism instead
 * @author Matt Wipfler
 * @see RightGenericPrism
 */
public class RightCylinder extends ThreeDimension {

    // Private members
    /** Faces shape- oval or circle*/
    private Oval baseShape;
    /** Distance from one face to the other*/
    private double height;

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     * @param baseShape Shape of base
     * @param height Distance from face to face
     */
    public RightCylinder(String name, Oval baseShape, double height){
        super(name);

        this.setBaseShape(baseShape);
        this.setHeight(height);
    }

    // Accessors
    /** Accessor for height. Cannot be less than 0*/
    public double getHeight(){return this.height;}
    /** Assessor for setting height*/
    public void setHeight(double height){
        if(height > 0){
            this.height = height;
        }
        else{
            throw new IllegalArgumentException("Cylinder height is below 0");
        }
    }

    /** Accessor for getting base shape*/
    public Oval getBaseShape() {return baseShape;}
    /** Accessor for setting base shape. Can not be null*/
    public void setBaseShape(Oval shape){
        if(shape != null){
            this.baseShape = shape;
        }
        else{
            throw new IllegalArgumentException("Cylinder base is null");
        }
    }

    @Override
    /** Implementation of abstract class 3D. Returns prism volume*/
    public double getVolume() {
        return this.baseShape.getArea() * this.height;
    }

    @Override
    /** Implementation of abstract class 3D. Returns prism surface area*/
    public double getSurfaceArea() {
        double faceSA = 2.0 * this.baseShape.getArea();
        return faceSA + this.baseShape.getPerimeter() * this.height;
    }
}
