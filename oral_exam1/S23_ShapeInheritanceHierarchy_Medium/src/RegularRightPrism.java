/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RegularRightPrism.java
 */

public class RegularRightPrism extends ThreeDimension{

    // Private members
    private RegularPolygon baseShape;
    private double height;

    // Constructor
    public RegularRightPrism(String name, RegularPolygon baseShape, double height){
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
            throw new IllegalArgumentException("Prism height is below 0");
        }
    }

    public RegularPolygon getBaseShape() {return baseShape;}
    public void setBaseShape(RegularPolygon shape){
        if(shape != null){
            this.baseShape = shape;
        }
        else{
            throw new IllegalArgumentException("Prism base is null");
        }
    }

    @Override
    public double getVolume() {
        return this.baseShape.getArea() * this.height;
    }

    @Override
    public double getSurfaceArea() {
        double faceSA = 2.0 * this.baseShape.getArea();
        return faceSA + this.height * this.baseShape.getPerimeter();
    }
}
