/*
    * Name: Matthew Wipfler
    * Date: 9/6/17
    * File: TerminalInteraction.java
    * Description: Methods for getting/displaying text to console
*/

import java.util.Scanner;

/**
 * Helper methods for encryption program and reading/writing from Terminal
 * @author Matt Wipfler
 */
public class TerminalInteraction {


    /**
     * DisplayList - Outputs string array to command prompt
     * @param bNumbered True if list should be numbered, False for plain string text
     * @param sMessageList StringArray to print
     */
    public static void DisplayList(Boolean bNumbered, String[] sMessageList){

        // Go through array and output each string
        for(int i = 0; i < sMessageList.length; i++){

            // Output index of string if desired (ex: 1. Hello world)
            if(bNumbered){
                System.out.print((i+1) + ". ");
            }

            // Print string from array
            System.out.println(sMessageList[i]);
        }
    }

    /**
     * GetValidEntry- Prompts user to enter a valid integer between two numbers
     * @param iMin Lowest integer user can enter
     * @param iMax Highest integer user can enter
     * @return The user's valid selection
     */
    public static int GetValidEntry(int iMin, int iMax){

        int iSelection = GetNumberFromTerminal();
        if(iSelection >= iMin && iSelection <= iMax){
            return  iSelection;
        }
        else {
            System.out.println("Number not in valid range, try again.");
            return GetValidEntry(iMin, iMax );
        }
    }

    /**
     * Gets a user inputted integer
     * @return Prompts and gets a number from the terminal
     */
    public static int GetNumberFromTerminal(){
        // Information about reading from command window found here:
        // https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
        Scanner kTerminal = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        return kTerminal.nextInt();
    }
}
