/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: HangmanModel.java
 */

import javax.swing.*;
import java.util.*;

/** Background logic for hangman*/
public class HangmanModel {

    // Private members
    /** Member to track number of tries left*/
    private int guessesLeft;
    /** List to add guessed letters to*/
    private List<Character> guessedLetters;
    /** Shhh... the first player can't know the hidden word/phrase*/
    private String secretWord;

    // Accessors
    /** Obtain the number of guesses left*/
    public int getGuessesLeft() {
        return guessesLeft;
    }
    /** Obtain the letters already guessed*/
    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    /**
     * Constructor
     * @param guessesLeft Initial number of tries
     * @param secretWord The word to hide and display correct guesses
     */
    public HangmanModel(int guessesLeft, String secretWord){
        this.guessesLeft = (guessesLeft < 2) ? 10 : guessesLeft;
        this.secretWord = secretWord.toLowerCase();
        guessedLetters = new ArrayList<>();
    }

    /**
     * Compares guess to previous characters
     * @param guess Character in to compare and/or add
     * @return True if character was previously guessed, false otherwise
     */
    public Boolean TakeInGuess(char guess){
        Boolean flag = false;

        // Check if letter has already been guessed
        if(!guessedLetters.contains(guess) && guess != ' '){
            if(secretWord.indexOf(guess) < 0){
                DecreaseCount();
            }
            guessedLetters.add(guess);
            flag = true;
        }
        else{
            JOptionPane.showMessageDialog( null,"Character already guessed!","Slight error...", JOptionPane.PLAIN_MESSAGE);
        }
        return flag;
    }

    /**
     * Take the secret phrase and only shows what characters have already been guessed
     * @return String with *s over unguessed characters
     */
    public String getHiddenMessage(){
        char[] hiddenMessage = this.secretWord.toCharArray();
        int changedLetters = 0;
        for(int i = 0; i < hiddenMessage.length; i++){
            char c = hiddenMessage[i];
            if(c != ' ' && !guessedLetters.contains(c)){
                hiddenMessage[i] = '*';
                changedLetters++;
            }
        }
        String concealedMessage = new String(hiddenMessage);
        if(concealedMessage.equals(this.secretWord)){
            JOptionPane.showMessageDialog(null,"You win!","End of Game- WINNER", JOptionPane.PLAIN_MESSAGE);
        }
        return concealedMessage;
    }

    /** Lowers guessesLeft and checks if program should exit*/
    private void DecreaseCount(){
        guessesLeft--;
        if(guessesLeft < 1){
            JOptionPane.showMessageDialog(
                    null,"You lost!","End of Game", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
