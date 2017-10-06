/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: NumericButton.java
 */

import javax.swing.*;

/**
 * Button to store associated char value. Used in
 * Calculator for inputting numbers to display. Is
 * a subclass of JButton.
 * @author Matt Wipfler
 * @see CalculatorView
 */
public class NumericCharButton extends JButton {

    // Private members
    /** Char affiliated with button*/
    private char associatedChar;

    // Accessors
    /** Accessor for button char*/
    public char getNumberChar(){return this.associatedChar;}

    /**
     * Constructor
     * @param newChar associated button character
     */
    public NumericCharButton(char newChar){
        super(Character.toString(newChar));

        this.associatedChar = newChar;
        this.setName("NumericCharButton"+Character.toString(newChar));
        this.setFocusable(false);
    }
}
