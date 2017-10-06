/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: HangmanView.java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * GUI for hangman application. Extends JFrame
 * @author Matt Wipfler
 */
public class HangmanView extends JFrame {

    // Private members
    /** Field to input character guess*/
    private final JTextField enterCharacterField;
    /** Button to press to call guess*/
    private final JButton enterGuessButton;

    /** Label for displaying secret word with correctly guessed letters*/
    private final JLabel correctLetters;
    /** Label for displaying list of guessed letters*/
    private final JLabel guessedLetters;
    /** Label for displaying number of guesses left*/
    private final JLabel guessesLeft;

    // Accessors
    /** Accessor that gets character from TextField and formats it to lowercase*/
    public char getCharacterGuess(){
        String entry = enterCharacterField.getText();
        if(entry.equals("") || entry.equals(" "))
        {
            return ' ';
        } else{
            return Character.toLowerCase(enterCharacterField.getText().charAt(0));
        }
    }
    /** Method to adjust secret message label text*/
    public void setHiddenMessage(String message){correctLetters.setText(message);}
    /** Method to update guess left label*/
    public void setGuessesLeftText(int countLeft){
        guessesLeft.setText(Integer.toString(countLeft));
    }
    /** Method to update guessed letters label*/
    public void setGuessedLettersText(String usedLetters){
        guessedLetters.setText(usedLetters);
    }
    /** Method to add ActionListener to GuessButton from an outside source*/
    public void addGuessButtonListener(ActionListener listener){
        enterGuessButton.addActionListener(listener);
    }

    /** Constructor*/
    public HangmanView() {
        // Set main window options
        super("Hangman!");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);

        // Initialize members
        enterCharacterField = new JTextField();
        enterGuessButton = new JButton("Try guess: ");
        correctLetters = new JLabel("");
        guessedLetters = new JLabel("");
        guessesLeft = new JLabel("");

        // Add GUI objects
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));
        mainPanel.add(setupUserInputGUI());
        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));
        mainPanel.add(correctLetters);
        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));
        mainPanel.add(setupGuessGUI());

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

    /**
     * Combines enterCharacterField and enterGuessButton to one subframe
     * @return Horizontal Panel with a textfield and button
     */
    private JPanel setupUserInputGUI() {
        JPanel kHorizontalFrame = new JPanel();
        kHorizontalFrame.setLayout(new BoxLayout(kHorizontalFrame, BoxLayout.X_AXIS));

        // Add field and button
        enterCharacterField.addKeyListener(new KeyAdapter() {
                                               @Override
                                               public void keyPressed(KeyEvent e) {
                                                   enterCharacterField.setText(null);
                                               }

                                               @Override
                                               public void keyReleased(KeyEvent e) {
                                                   if (Character.isLetterOrDigit(e.getKeyChar())) {
                                                       enterCharacterField.setText(Character.toString(Character.toLowerCase(e.getKeyChar())));
                                                   }
                                               }
                                           }
        );
        enterCharacterField.setAlignmentX(CENTER_ALIGNMENT);
        enterCharacterField.setMaximumSize(new Dimension(20, 20));
        enterCharacterField.setHorizontalAlignment(SwingConstants.CENTER);
        enterGuessButton.setFocusable(false);

        // Add components to sub-frame
        kHorizontalFrame.add(new JLabel("Enter guess here:  "));
        kHorizontalFrame.add(Box.createRigidArea(new Dimension(3,0)));
        kHorizontalFrame.add(enterCharacterField);
        kHorizontalFrame.add(Box.createRigidArea(new Dimension(6,0)));
        kHorizontalFrame.add(enterGuessButton);

        return kHorizontalFrame;
    }

    /**
     * Combines guessedLetters and guessesLeft labels into one horizontal subframe
     * @return A Panel containing labels for displaying guess info
     */
    private JPanel setupGuessGUI(){
        JPanel kHorizontalFrame = new JPanel();
        kHorizontalFrame.setLayout(new BoxLayout(kHorizontalFrame, BoxLayout.X_AXIS));

        // Add components to sub frame
        kHorizontalFrame.add(new JLabel("Guessed Letters: "));
        kHorizontalFrame.add(Box.createRigidArea(new Dimension(3,0)));
        kHorizontalFrame.add(guessedLetters);
        kHorizontalFrame.add(Box.createRigidArea(new Dimension(6,0)));
        kHorizontalFrame.add(new JLabel("Guesses Left: "));
        kHorizontalFrame.add(Box.createRigidArea(new Dimension(5,0)));
        kHorizontalFrame.add(guessesLeft);

        return kHorizontalFrame;
    }
}
