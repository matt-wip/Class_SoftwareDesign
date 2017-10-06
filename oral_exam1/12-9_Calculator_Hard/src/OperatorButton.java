/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: OperatorButton.java
 */

import javax.swing.*;

public class OperatorButton extends JButton {

    // Region private members
    private MathOperatorEnum mathEnum;

    // Accessors
    public MathOperatorEnum getMathEnum(){return this.mathEnum;}

    // Constructor
    public OperatorButton(MathOperatorEnum mathOperator, String name){
        super(name);

        this.mathEnum = mathOperator;
        this.setName("OperatorButton"+name);
        this.setFocusable(false);
    }
}