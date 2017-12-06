package src;/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: HangmanModel.java
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/** Background logic for hangman*/
public class HangmanModel {

    // Private members
    private int guessesLeft;
    private List<Character> guessedLetters;
    private String secretWord;

    // Accessors
    public int getGuessesLeft() {
        return guessesLeft;
    }
    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    // Constructor
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
