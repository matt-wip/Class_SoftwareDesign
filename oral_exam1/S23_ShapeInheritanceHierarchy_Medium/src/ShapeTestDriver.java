/*
 * Name: Matthew Wipfler
 * Date: 10/4/17
 * File: ShapeTestDriver.java
 */

import com.sun.javafx.geom.Vec3d;
import javafx.scene.shape.Cylinder;

public class ShapeTestDriver {

    public static void main(String[] args){

        OneDimensionObjects();
        TwoDimensionObjects();
        ThreeDimensionObjects();

        System.out.println("Completed Shape Testing");
    }

    private static void OneDimensionObjects(){
        System.out.println("*** TESTING ONE DIMENSION ***");

        Line kLine = new Line("Line", 2.5);
        System.out.println(kLine.toString());
        System.out.println("Rotating line object 45 degrees");
        kLine.setRotation(new Vec3d(Math.PI/4.0,0,0));
        System.out.println("Line end point: " + kLine.getLineEndCoordinates().toString());
        System.out.println("Line color: " + kLine.getColor().toString());
    }

    private static void TwoDimensionObjects(){
        System.out.println("\n*** TESTING TWO DIMENSIONS ***");

        Rectangle kRectangle = new Rectangle("Rectangle", 5,3);
        System.out.println(kRectangle.toString());
        System.out.println("Dimensions: " + kRectangle.getSideALength() + " x " + kRectangle.getSideBLength() + "\n");

        Square kSquare = new Square("Square",7);
        System.out.println(kSquare.toString());
        System.out.println("Changing side length to 10:");
        kSquare.setSideBLength(10);
        System.out.println(kSquare.toString() + "\n");

        Rhomboid kRhomboid = new Rhomboid("Rhomboid",10,5,Math.PI/8.0);
        System.out.println(String.format("Side lengths: %s, %s",kRhomboid.getSideALength(), kRhomboid.getSideBLength()));
        System.out.println(kRhomboid.toString());
        System.out.println("Rhomboid background color: " + kRhomboid.getBackGroundColor().toString() + "\n");

        RightTriangle kRightTri = new RightTriangle("Right Triangle",3.0,4.0);
        System.out.println(kRightTri.toString());
        System.out.println(String.format("Side lengths: %s, %s",kRightTri.getSideLengthA(),kRightTri.getSideLengthB()) + "\n");

        ScaleneTriangle kScaleneTri = new ScaleneTriangle("Scalene Triangle",5.3,2.1, 0.32);
        System.out.println(kScaleneTri.toString());
        System.out.println(String.format("Side lengths: %s, %s", kScaleneTri.getSideLengthA(), kScaleneTri.getSideLengthB()));

        RegularPolygon kPoly = new RegularPolygon("Regular Polygon", 5, 2);
        System.out.println(kPoly.toString());
        System.out.println(String.format("Number of sides: %s. Length of a side: %s",kPoly.getSideCount(),kPoly.getSideLength())+"\n");
        kPoly.setSideLength(1.2);
        kPoly.setSideCount(7);
        System.out.println(kPoly.toString());
        System.out.println(String.format("Number of sides: %s. Length of a side: %s",kPoly.getSideCount(),kPoly.getSideLength()));

    }

    private static void ThreeDimensionObjects(){
        System.out.println("\n*** TESTING THREE DIMENSIONS ***");

        RegularRightPyramid kPyramid = new RegularRightPyramid("Regular pyramid",new RegularPolygon("BasePyra",4,4),5);
        System.out.println(kPyramid.toString());
        System.out.println(String.format("Pyramid height: %s. Pyramid base:: %s",kPyramid.getHeight(),kPyramid.getBaseShape().toString()) + "\n");

        RightCylinder kCylinder = new RightCylinder("Oval cylindar", new Oval("oval",5,2),10);
        System.out.println(kCylinder.toString());
        System.out.println(String.format("Cylindar height: %s. Cylindar base info:: %s",kCylinder.getHeight(),kCylinder.getBaseShape().toString()) +"\n");

        RegularRightPrism kPrism = new RegularRightPrism("Right prism", new RegularPolygon("hexagon",6,2),6);
        System.out.println(kPrism.toString());
        System.out.println(String.format("Prism height: %s. Base info:: %s",kPrism.getHeight(), kPrism.getBaseShape().toString())+"\n");
    }
}
