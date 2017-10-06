/*
   * Name: Matthew Wipfler
   * Date: 10/6/17
   * File: RightGenericPrism.java
*/

/**
 * Code for creating a generic Right prism. Bases are parallel and have centroids lining up 90 degrees to faces
 * @author Matt Wipfler
 */
public class RightGenericPrism extends ThreeDimension {

    // Private members
    /** Faces shape- oval or circle*/
    private TwoDimension baseShape;
    /** Distance from one face to the other*/
    private double height;

    // Constructor
    /**
     * Constructor
     * @param name Name of Shape
     * @param baseShape Shape of base
     * @param height Distance from face to face
     */
    public RightGenericPrism(String name, TwoDimension baseShape, double height){
        super(name);

        this.setBaseShape(baseShape);
        this.setHeight(height);
    }

    // Accessors
    /** Accessor for prism height*/
    public double getHeight(){return this.height;}
    /** Accessor for setting prism height. Cannot be less than 0*/
    public void setHeight(double height){
        if(height > 0){
            this.height = height;
        }
        else{
            throw new IllegalArgumentException("Cylinder height is below 0");
        }
    }

    /** Accessor for getting prism base shape*/
    public TwoDimension getBaseShape() {return baseShape;}
    /** Accessor for setting prism base shape. Can not be null*/
    public void setBaseShape(TwoDimension shape){
        if(shape != null){
            this.baseShape = shape;
        }
        else{
            throw new IllegalArgumentException("Cylinder base is null");
        }
    }

    @Override
    /** Implementation of abstract class 3D. Returns volume of prism*/
    public double getVolume() {
        return this.baseShape.getArea() * this.height;
    }

    @Override
    /** Implementation of abstract class 3D. Returns SA of prism*/
    public double getSurfaceArea() {
        double faceSA = 2.0 * this.baseShape.getArea();
        return faceSA + this.baseShape.getPerimeter() * this.height;
    }
}
