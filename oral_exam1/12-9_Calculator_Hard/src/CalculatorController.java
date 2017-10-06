/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorController.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Linker class for CalculatorHard. Controller of MVC framework.*/
public class CalculatorController {

    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    /**
     * Constructor
     */
    public CalculatorController(CalculatorView view, CalculatorModel model){
        this.calculatorModel = model;
        this.calculatorView = view;

        view.addNumericButtonListener(new NumericButtonHandler());
        view.addOperatorButtonListener(new OperatorButtonHandler());
    }

    class NumericButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Double check that sender is NumericCharButton
            if(e.getSource() instanceof NumericCharButton) {
                String newString = formNewString(((NumericCharButton)e.getSource()).getNumberChar());
                calculatorView.setInputText(newString);
            }
        }
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

    class OperatorButtonHandler implements ActionListener{
        @Override
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
