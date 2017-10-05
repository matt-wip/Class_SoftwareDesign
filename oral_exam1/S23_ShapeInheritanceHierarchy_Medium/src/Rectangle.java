/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: Rectangle.java
 */

public class Rectangle extends Parallelogram {

    public Rectangle(String name, double sideALength, double sideBLength){
        super(name,sideALength,sideBLength);
    }

    @Override
    public double getArea() {
        return this.getSideALength() * this.getSideBLength();
    }
}
