/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: RegularPolygon.java
 */
public class RegularPolygon extends TwoDimension {

    // Private members
    private int sideCount;
    private double sideLength;

    // Constructor
    public RegularPolygon(String name, int sideCount, double sideLength){
        super(name);

       this.setSideCount(sideCount);
       this.setSideLength(sideLength);
    }

    // Accessors
    public int getSideCount() {
        return sideCount;
    }
    public void setSideCount(int sideCount) {
        if(sideCount >= 3){
            this.sideCount = sideCount;
        }else{
            throw new IllegalArgumentException("Polygon must have at least 3 sides");
        }
    }

    public double getSideLength() {
        return sideLength;
    }
    public void setSideLength(double sideLength) {
        if(sideLength > 0) {
            this.sideLength = sideLength;
        }else{
            throw new IllegalArgumentException("Side length must be greater than 0");
        }
    }


    @Override
    public double getArea() {
        return 0.5 * this.getApothem() * this.getPerimeter();
    }

    @Override
    public double getPerimeter(){
        return (double)this.sideCount * this.sideLength;
    }

    /**
     * Calculates the apothem of a regular polygon (center to center of a side)
     * @return length of apothem
     */
    public double getApothem(){
        return (this.sideLength / (2.0 * Math.tan(Math.PI / (double)this.sideCount)));
    }
}
