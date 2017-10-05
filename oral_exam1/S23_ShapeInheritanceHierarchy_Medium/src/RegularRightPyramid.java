/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: ThreeDimension.java
 */

public class RegularRightPyramid extends ThreeDimension{

    // Private members
    private RegularPolygon baseShape;
    private double height;

    // Constructor
    public RegularRightPyramid(String name, RegularPolygon baseShape, double height){
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
            throw new IllegalArgumentException("Pyramid height is below 0");
        }
    }

    public RegularPolygon getBaseShape() {return baseShape;}
    public void setBaseShape(RegularPolygon shape){
        if(shape != null){
            this.baseShape = shape;
        }
        else{
            throw new IllegalArgumentException("Pyramid base is null");
        }
    }

    @Override
    public double getVolume() {
        return (1.0/3.0) * this.baseShape.getArea() * this.height;
    }

    @Override
    public double getSurfaceArea() {
        double lateralSA = 0.5 * this.getSlantLength() * this.baseShape.getPerimeter();
        return lateralSA + this.baseShape.getArea();
    }

    public double getSlantLength(){
        double slantLength = Math.pow(this.baseShape.getApothem(),2) + Math.pow(this.height,2);
        slantLength = Math.sqrt(slantLength);
        return slantLength;
    }
}
