/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: CalculatorView.java
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/** View component of MVC framework. Implements GUI*/
public class CalculatorView extends JFrame{

    // Private members
    private final NumericCharButton zeroButton;
    private final NumericCharButton oneButton;
    private final NumericCharButton twoButton;
    private final NumericCharButton threeButton;
    private final NumericCharButton fourButton;
    private final NumericCharButton fiveButton;
    private final NumericCharButton sixButton;
    private final NumericCharButton sevenButton;
    private final NumericCharButton eightButton;
    private final NumericCharButton nineButton;
    private final NumericCharButton dotButton;

    private final OperatorButton equalButton;
    private final OperatorButton plusButton;
    private final OperatorButton minusButton;
    private final OperatorButton timesButton;
    private final OperatorButton divideButton;

    private final JTextField inputField;

    // Accessors
    public String getInputText() {
        return inputField.getText();
    }
    public void setInputText(String input) {
        this.inputField.setText(input);
    }
    public OperatorButton getEqualButton() {return equalButton;}

    // Constructor
    public CalculatorView(){
        // Set main window options
        super("Calculator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Initialize members
        zeroButton = new NumericCharButton('0');
        oneButton = new NumericCharButton('1');
        twoButton = new NumericCharButton('2');
        threeButton = new NumericCharButton('3');
        fourButton = new NumericCharButton('4');
        fiveButton = new NumericCharButton('5');
        sixButton = new NumericCharButton('6');
        sevenButton = new NumericCharButton('7');
        eightButton = new NumericCharButton('8');
        nineButton = new NumericCharButton('9');
        dotButton = new NumericCharButton('.');

        equalButton = new OperatorButton(MathOperatorEnum.EQUAL,"=");
        plusButton = new OperatorButton(MathOperatorEnum.ADDITION,"+");
        minusButton = new OperatorButton(MathOperatorEnum.SUBTRACTION,"-");
        timesButton = new OperatorButton(MathOperatorEnum.MULTIPLICATION,"*");
        divideButton = new OperatorButton(MathOperatorEnum.DIVISION,"/");

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setPreferredSize(new Dimension(100,40));

        // Add GUI objects to panels
        JPanel mainPanel = new JPanel( new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(4,4,10,10));
        buttonPanel.setBorder(new EmptyBorder(10,10,10,10));
        _AddControls(buttonPanel);

        mainPanel.add(inputField, BorderLayout.PAGE_START);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

    /** Called by CalculatorController to connect Model logic to buttons*/
    public void addNumericButtonListener(ActionListener listener){
        this.zeroButton.addActionListener(listener);
        this.oneButton.addActionListener(listener);
        this.twoButton.addActionListener(listener);
        this.threeButton.addActionListener(listener);
        this.fourButton.addActionListener(listener);
        this.fiveButton.addActionListener(listener);
        this.sixButton.addActionListener(listener);
        this.sevenButton.addActionListener(listener);
        this.eightButton.addActionListener(listener);
        this.nineButton.addActionListener(listener);
        this.dotButton.addActionListener(listener);
    }

    /** Called by CalculatorController to connect Model logic to buttons*/
    public void addOperatorButtonListener(ActionListener listener){
        this.equalButton.addActionListener(listener);
        this.plusButton.addActionListener(listener);
        this.minusButton.addActionListener(listener);
        this.timesButton.addActionListener(listener);
        this.divideButton.addActionListener(listener);
    }

    // Private Methods
    // used to use a helper in constructor to initialize members, changed for final modifier

    /** helper method for creating GUI*/
    private void _AddControls(JPanel buttonPanel){
        buttonPanel.add(sevenButton, 0);
        buttonPanel.add(eightButton,1);
        buttonPanel.add(nineButton, 2);
        buttonPanel.add(divideButton,3);
        buttonPanel.add(fourButton,4);
        buttonPanel.add(fiveButton,5);
        buttonPanel.add(sixButton,6);
        buttonPanel.add(timesButton, 7);
        buttonPanel.add(oneButton, 8);
        buttonPanel.add(twoButton,9);
        buttonPanel.add(threeButton, 10);
        buttonPanel.add(minusButton,11);
        buttonPanel.add(zeroButton,12);
        buttonPanel.add(dotButton,13);
        buttonPanel.add(equalButton, 14);
        buttonPanel.add(plusButton, 15);
    }
}
