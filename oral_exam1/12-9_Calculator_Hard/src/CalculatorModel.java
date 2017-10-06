/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorModel.java
 */

/** Background logic for hangman. Model for MVC framework*/
public class CalculatorModel {

    // Private members
    /** Previous number of calculator*/
    private double result;
    /** User selected Operator*/
    private MathOperatorEnum selectedOperation;

    // Accessors
    /** Sets the desired operator.
     * @see CalculatorController*/
    public void setMathOperation(MathOperatorEnum mathOperation){this.selectedOperation = mathOperation;}

    /**
     * Sets the previous number of calculator
     * @param newNumber String to convert to number
     */
    public void setResult(String newNumber){
        if(newNumber == null || newNumber.equals("")){
            result = 0;}
        else{
            result = Double.parseDouble(newNumber);
        }
    }

    /**Constructor*/
    public CalculatorModel() {
        result = 0;
        selectedOperation = MathOperatorEnum.ADDITION;
    }

    /**
     * Takes a previous and new number, does math operator on the previous number
     * @param newNumber String to convert to new number
     * @return end result due to math operand
     */
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