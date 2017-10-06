package src;/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: HangmanController.java
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Ties view and model together*/
public class HangmanController {

    // Private members
    private HangmanModel hangmanModel;
    private HangmanView hangmanView;

    /**Constructor*/
    public HangmanController(HangmanView hangmanView, HangmanModel hangmanModel){
        this.hangmanModel = hangmanModel;
        this.hangmanView = hangmanView;

        hangmanView.addGuessButtonListener(new GuessButtonHandler());
    }


     class GuessButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Update View if the character is a new guess
            if(hangmanModel.TakeInGuess(hangmanView.getCharacterGuess())){
                UpdateGUI();
            }
        }

        // Update necessary displays: guessLeft, guessedLetters, correctAnswer
        private void UpdateGUI(){
            hangmanView.setGuessesLeftText(hangmanModel.getGuessesLeft());
            hangmanView.setGuessedLettersText(hangmanModel.getGuessedLetters().toString());
            hangmanView.setHiddenMessage(hangmanModel.getHiddenMessage());
        }
    }
}
