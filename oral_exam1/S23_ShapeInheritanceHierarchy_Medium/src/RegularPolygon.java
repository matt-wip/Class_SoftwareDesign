/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RegularPolygon.java
 */
public class RegularPolygon extends TwoDimension {

    private int sideCount;
    private double sideLength;

    public RegularPolygon(String name, int sideCount, double sideLength){
        super(name);

        if(sideCount <= 0 || sideLength <= 0){
            throw new IllegalArgumentException("Side count and side length have to be greater than 0");
        }
        this.sideCount = sideCount;
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return (Math.pow(this.sideLength,2)*this.sideLength) / (4*Math.tan(180.0/this.sideCount));
    }

    @Override
    public double getPerimeter(){
        return (double)this.sideCount * this.sideLength;
    }
}
