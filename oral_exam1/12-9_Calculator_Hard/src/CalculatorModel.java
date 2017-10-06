/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorModel.java
 */

/** Background logic and behavior for hangman*/
public class CalculatorModel {

    // Private members
    private double result;
    private MathOperatorEnum selectedOperation;

    // Accessors
    public void setMathOperation(MathOperatorEnum mathOperation){this.selectedOperation = mathOperation;}
    public void setResult(String newNumber){
        if(newNumber == null || newNumber.equals("")){
            result = 0;}
        else{
            result = Double.parseDouble(newNumber);
        }
    }

    // Constructor
    public CalculatorModel() {
        result = 0;
        selectedOperation = MathOperatorEnum.ADDITION;
    }

    public double calculateResult(String newNumber){
        // If number is not valid, return existing result
        if(newNumber == null || newNumber.equals(""))
            return this.result;

        // Convert number to double
        double number = Double.parseDouble(newNumber);

        // Do calculations based on operator
        switch (this.selectedOperation){
            case ADDITION:
                result += number;
                break;
            case SUBTRACTION:
                result -= number;
                break;
            case MULTIPLICATION:
                result *= number;
                break;
            case DIVISION:
                if(number != 0)
                    result /= number;
                break;
            default:
                break;
        }

        return this.result;
    }
}