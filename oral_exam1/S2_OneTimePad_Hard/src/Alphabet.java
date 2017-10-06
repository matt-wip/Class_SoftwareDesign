/*
    * Name: Matthew Wipfler
    * Date: 8/25/17
    * File: Alphabet.java
    * Description: Contains an array of letters representing the English alphabet and methods to convert from
    * an integer to letter and from a number to an integer.
*/

/**
 * Class for converting a number into a letter and vice versa
 * @author Matt Wipfler
 */
public class Alphabet {

    /** Array of letters and a special char. Final, static.*/
    private final static char alphabet[] = {'-','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    /**
     * ToLetter - Takes a number between 1 and 26 and returns the corresponding letter
     * @param i Index of letter in alphabet. Valid between 1 and 26
     * @return Letter of alphabet (in caps)
     */
    public static char ToLetter(int i){

        // Make sure integer is a valid number (1 to 26)
        if(i < 0 || i > 26){
            return alphabet[0]; // space character
        }

        return alphabet[i];
    }

    /**
     * ToNumber- converts a letter to its index in the alphabet
     * @param letter Character of English alphabet
     * @return Index of letter in alphabet (1-26)
     */
    public static int ToNumber(char letter){

        // Make sure letter is in caps
        letter = Character.toUpperCase(letter);

        // Find index in alphabet
        for(int i = 1; i < alphabet.length; i++){
            if(letter == alphabet[i]){
                return i;
            }
        }
        return 0; // Invalid letter. Return space character index of alphabet array.
    }
}
