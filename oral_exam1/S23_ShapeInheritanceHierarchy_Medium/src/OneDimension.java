/*
 * Name: Matthew Wipfler
 * Date: 9/16/17
 * File: OneDimension.java
 */

/**
 * Sttandard class for 1D object
 * @author Matt Wipfler
 */
public abstract class OneDimension extends Shape {


    // Accessor
    /** Accessor- gets 1D length*/
    public abstract double getLength();
    /** Accessor- sets 1D length*/
    public abstract void setLength(double length);

    // Constructor
    /**
     * Constructor
     */
    public OneDimension(String name){
        super(name);
    }

    @Override
    /**
     * Returns String of shape information
     */
    public String toString(){
        String message = String.format("Info for object %s: \n", this.getName());
        message += "Length: " + this.getLength();
        return message;
    }
}


