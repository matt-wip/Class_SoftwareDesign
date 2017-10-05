/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: HangmanWindow.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HangmanWindow extends JFrame implements ActionListener{

    // Private members
    private int initialGuessCount;

    private JTextField enterCharacterField;
    private JButton enterGuessButton;

    private JLabel hiddenWordDisplay;
    private JLabel guessedCharacters;
    private JLabel guessesLeft;

    // Constructor
    public HangmanWindow(int intitalGuessCount){
        // Set main window options
        super("Hangman!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);

        // Initialize members
        this.initialGuessCount = ((initialGuessCount < 1) ? 10 : initialGuessCount);
        enterCharacterField = new JTextField();
        enterGuessButton= new JButton("Try guess:");

        // Add GUI interaction
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(createUserInput());

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

    private JPanel createUserInput(){
        JPanel kHorizontalFrame = new JPanel();
        kHorizontalFrame.setLayout(new BoxLayout(kHorizontalFrame, BoxLayout.X_AXIS));

        // Add field and button
        enterCharacterField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                enterCharacterField.setText(null);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(Character.isLetterOrDigit(e.getKeyChar())){
                    enterCharacterField.setText(Character.toString(Character.toLowerCase(e.getKeyChar())));
                }
            }}
        );
        enterCharacterField.setAlignmentX(CENTER_ALIGNMENT);
        enterCharacterField.setMaximumSize(new Dimension(20,20));
        enterCharacterField.setHorizontalAlignment(SwingConstants.CENTER);
        enterGuessButton.addActionListener(this);

        // Add components to sub-frame
        kHorizontalFrame.add(new JLabel("Enter guess here:  "));
        kHorizontalFrame.add(enterCharacterField);
        kHorizontalFrame.add(enterGuessButton);

        return kHorizontalFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Check if valid chaar is entered
        if(e.getSource() != enterGuessButton)
            return;

        String guess = enterCharacterField.getText();
        if(guess.equalsIgnoreCase(" ") || guess.equalsIgnoreCase("") || guess.length() > 1){
            return;
        }
        char cGuess = guess.charAt(0);


    }
}
