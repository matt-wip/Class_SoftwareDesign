/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: ThreeDimension.java
 */

/** Base class for 3D objects*/
public abstract class ThreeDimension extends Shape {
//cube, cylinder, sphere
    // Constructor
    public ThreeDimension(String name){
        super(name);
    }

    // Methods
    public abstract double getVolume();
    public abstract double getSurfaceArea();

    @Override
    public String toString(){
        String message = String.format("Info for object %s: \n", this.getName());
        message += "Volume: " + this.getVolume() + "\n";
        message += "Surface area: " + this.getSurfaceArea() + "\n";
        return message;
    }
}
