/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorController.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Linker class for Calculator */
public class CalculatorController {

    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView view, CalculatorModel model){
        this.calculatorModel = model;
        this.calculatorView = view;

        view.addNumericButtonListener(new NumericButtonListener());
        view.addOperatorButtonListener(new OperatorButtonListener());
    }

    class NumericButtonListener implements ActionListener{
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

    class OperatorButtonListener implements ActionListener{
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
