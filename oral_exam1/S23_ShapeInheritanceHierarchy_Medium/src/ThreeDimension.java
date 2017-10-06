/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: ThreeDimension.java
 */

/** Base class for 3D objects*/
public abstract class ThreeDimension extends Shape {
//cube, cylinder, sphere
    // Constructor

    /**
     * Constructor
     * @param name Name of Shape
     */
    public ThreeDimension(String name){
        super(name);
    }

    // Methods
    /** Abstract method for obtaining object's volume*/
    public abstract double getVolume();
    /** Abstract method for obtaining object's surface area*/
    public abstract double getSurfaceArea();

    /** Formats and returns generic info about shape*/
    @Override
    public String toString(){
        String message = String.format("Info for object %s: \n", this.getName());
        message += "Volume: " + this.getVolume() + "\n";
        message += "Surface area: " + this.getSurfaceArea();
        return message;
    }
}
