/*
        * Name: Matthew Wipfler
        * Date: 10/4/17
        * File: RightCylinder.java
        */

public class RightCylinder extends ThreeDimension {

    // Private members
    private Oval baseShape;
    private double height;

    // Constructor
    public RightCylinder(String name, Oval baseShape, double height){
        super(name);

        this.setBaseShape(baseShape);
        this.setHeight(height);
    }

    // Accessors
    public double getHeight(){return this.height;}
    public void setHeight(double height){
        if(height > 0){
            this.height = height;
        }
        else{
            throw new IllegalArgumentException("Cylinder height is below 0");
        }
    }

    public Oval getBaseShape() {return baseShape;}
    public void setBaseShape(Oval shape){
        if(shape != null){
            this.baseShape = shape;
        }
        else{
            throw new IllegalArgumentException("Cylinder base is null");
        }
    }

    @Override
    public double getVolume() {
        return this.baseShape.getArea() * this.height;
    }

    @Override
    public double getSurfaceArea() {
        double faceSA = 2.0 * this.baseShape.getArea();
        return faceSA + this.baseShape.getPerimeter() * this.height;
    }
}
