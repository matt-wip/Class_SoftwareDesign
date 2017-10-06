/*
 * Name: Matthew Wipfler
 * Date: 10/5/17
 * File: HangmanDriver.java
 */

import com.sun.xml.internal.ws.policy.subject.WsdlBindingSubject;

import javax.swing.*;

/**
 * Driver class for Hangman application. Creates Model, View, and Controller components
 */
public class HangmanDriver {

    /**  Main method. Program does not use arguments*/
    public static void main(String[] args){
        HangmanModel hangmanModel = new HangmanModel(10, JOptionPane.showInputDialog(
               null,"Player 1, type in your secret word/phrase","Input word/phrase", JOptionPane.QUESTION_MESSAGE));
        HangmanView hangmanView = new HangmanView();
        HangmanController hangmanController = new HangmanController(hangmanView, hangmanModel);
    }
}
