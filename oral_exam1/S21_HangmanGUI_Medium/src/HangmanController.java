/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: HangmanController.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Ties view and model together*/
public class HangmanController {

    // Private members
    /** Model component in MVC framework*/
    private HangmanModel hangmanModel;
    /** View component in MVC framework*/
    private HangmanView hangmanView;

    /**
     * Constructor, adds listeners
     * @param hangmanModel Associated logic for application
     * @param hangmanView Associated GUI for application
     */
    public HangmanController(HangmanView hangmanView, HangmanModel hangmanModel){
        this.hangmanModel = hangmanModel;
        this.hangmanView = hangmanView;

        hangmanView.addGuessButtonListener(new GuessButtonHandler());
    }

    /**
     * Handler for any component to call a guess. Implements ActionListener
     * Process letter guess (Mmdel) and updates GUI (view)
     */
     class GuessButtonHandler implements ActionListener{
        @Override
        /** Implementation of ActionListener*/
        public void actionPerformed(ActionEvent e) {
            // Update View if the character is a new guess
            if(hangmanModel.TakeInGuess(hangmanView.getCharacterGuess())){
                // Update GUI
                hangmanView.setGuessesLeftText(hangmanModel.getGuessesLeft());
                hangmanView.setGuessedLettersText(hangmanModel.getGuessedLetters().toString());
                hangmanView.setHiddenMessage(hangmanModel.getHiddenMessage());
            }
        }
    }
}
