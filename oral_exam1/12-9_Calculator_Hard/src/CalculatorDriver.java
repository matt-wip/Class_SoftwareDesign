/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorDriver.java
 */

/**
 * Driver class for Calculator application. Creates a View,
 * Model, and Controller component to work together
 * @author Matt Wipfler
 */
public class CalculatorDriver {

    /** Main method. Does not use any arguments
     * @param args No arguments used*/
    public static void main(String[] args){
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
    }
}
