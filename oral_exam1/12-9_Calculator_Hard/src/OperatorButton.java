/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: OperatorButton.java
 */

import javax.swing.*;

/**
 * Button to store . Used in calculations.
 * Is a subclass of JButton.
 * @author Matt Wipfler
 * @see CalculatorView
 * @see MathOperatorEnum
 */
public class OperatorButton extends JButton {

    // Region private members
    /** Enum to distinguish operator*/
    private MathOperatorEnum mathEnum;

    // Accessors
    /** Accessor to button's affiliated operator*/
    public MathOperatorEnum getMathEnum(){return this.mathEnum;}

    /**
     * Constructor
     * @param mathOperator Affiliated operator enum
     * @param name Displayed name of button
     */
    public OperatorButton(MathOperatorEnum mathOperator, String name){
        super(name);

        this.mathEnum = mathOperator;
        this.setName("OperatorButton"+name);
        this.setFocusable(false);
    }
}