/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: NumericButton.java
 */

import javax.swing.*;

public class NumericCharButton extends JButton {

    // Region private members
    private char number;

    // Accessors
    public char getNumberChar(){return this.number;}

    // Constructor
    public NumericCharButton(char number){
        super(Character.toString(number));

        this.number = number;
        this.setName("NumericCharButton"+Character.toString(number));
        this.setFocusable(false);
    }
}
