/*
 * Name: Matthew Wipfler
 * Date: 9/16/17
 * File: OneDimension.java
 */

public class OneDimension extends Shape {

    private double length;

    // Accessor
    public double getLength(){return length;}
    public void setLength(double length){
        this.length = length;
    }

    // Constructor
    public OneDimension(String name){
        super(name);
        length = 0;
    }
    // Default constructor
    public OneDimension(){
        this("");
        length = 0;
    }

    @Override
    public String toString(){
        String message = String.format("Info for object %s: \n", this.getName());
        message += "Length: " + this.getLength();
        return message;
    }
}


