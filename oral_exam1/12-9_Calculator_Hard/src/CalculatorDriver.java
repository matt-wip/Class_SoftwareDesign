/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorDriver.java
 */

public class CalculatorDriver {

    public static void main(String[] args){

        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
    }
}
