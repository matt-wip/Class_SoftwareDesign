/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorController.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Linker class for CalculatorHard. Controller of Calculator MVC framework.
 * @author Matt Wipfler
 */
public class CalculatorController {

    /** View component. Used for GUI interaction and updating displays*/
    private CalculatorView calculatorView;
    /** Model component. Used for calculations and storing calculator instance members*/
    private CalculatorModel calculatorModel;

    /**
     * Constructor for class. Connects Handlers to GUI
     * @param view View component of framework
     * @param model Model component of framework
     */
    public CalculatorController(CalculatorView view, CalculatorModel model){
        this.calculatorModel = model;
        this.calculatorView = view;

        view.addNumericButtonListener(new NumericButtonHandler());
        view.addOperatorButtonListener(new OperatorButtonHandler());
    }

    /** Handler for numeric buttons action events (0-9)
     *  Adds associated buttonchar to Calculator input*/
    class NumericButtonHandler implements ActionListener{
        @Override
        /** Implementation of ActionListener*/
        public void actionPerformed(ActionEvent e) {
            // Double check that sender is NumericCharButton
            if(e.getSource() instanceof NumericCharButton) {
                String newString = formNewString(((NumericCharButton)e.getSource()).getNumberChar());
                calculatorView.setInputText(newString);
            }
        }

        /**
         * Helper method. Adds new char to existing input string.
         * Does not allow more than two '.'s in input string
         * @param newChar Char to append
         * @return new string with char
         */
        private String formNewString(char newChar){
            String existingString = calculatorView.getInputText();
            if(newChar == '.' ){
                if(existingString.indexOf(newChar)<0) // not found
                    existingString  += newChar;
            }
            else{
                existingString += newChar;
            }
            return existingString;
        }
    }

    /**
     * Handler for operation buttons (+,-,/,*,=). "=" operator
     * is handled differently than the others. Communicates with
     * View and Model framework components.
     */
    class OperatorButtonHandler implements ActionListener{
        @Override
        /**Implementation of ActionListener*/
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof OperatorButton){
                OperatorButton button = (OperatorButton)e.getSource();
                if(button.getMathEnum() == MathOperatorEnum.EQUAL){
                    // Calculate result
                    double result = calculatorModel.calculateResult(calculatorView.getInputText());

                    // Update display
                    calculatorView.setInputText(Double.toString(result));
                }
                else{
                    // Clear input
                    calculatorModel.setResult(calculatorView.getInputText());
                    calculatorView.setInputText("");

                    // Update enum in calculation
                    calculatorModel.setMathOperation(button.getMathEnum());
                }
            }
        }
    }

}
