/*
    * Name: Matthew Wipfler
    * Date: 8/25/17
    * File: EncryptionManagement.java
    * Description: Provides an interface for creating and modifying encrypted files. Also can generate unique keys.
*/

import java.util.Scanner;

public class EncryptionManagement {

    /**
     * main - method to run for encryption program to work
     * @param args In this code, there are no necessary arguments
     */
    public static void main(String[] args) {

        // Note: there are no arguments for the management system. This is due to
        // not knowing what the user wants to accomplish (generate key, encrypt, decrypt)

        // Create options for this program
        final String[] sMenuOptions = { "Create new key", "Encrypt a message", "Decrypt a file", "Exit" };

        // Enter loop for manager. Program runs until exited
        Boolean bRun = true;
        Scanner kTerminal = new Scanner(System.in);
        while (bRun) {
            // Display menu to console
            System.out.println("\nChoose an option from below:");
            DisplayList(true, sMenuOptions);

            int iChoice = GetValidEntry(1, sMenuOptions.length);
            switch (iChoice){
                case 1:{    // Create new key
                    System.out.println("Enter amount of numbers for key file:");
                    String sKeyPath = KeyGenerator.CreateNewKey(GetValidEntry(0, 2147483647 ));
                    System.out.println("Key path: " + sKeyPath);
                    break;
                }
                case 2:{    // Encrypt file
                    System.out.println("Enter message to encrypt:");
                    String sMessage = kTerminal.nextLine();
                    System.out.println("Enter key file path:");
                    String sKeyPath = kTerminal.nextLine();

                    System.out.println("Encryptor message: "+ Encryptor.EncryptMessageWithKey(sKeyPath,sMessage));
                    break;
                }
                case 3:{    // Decrypt file
                    System.out.println("Enter encrypted message path:");
                    String sMessagePath = kTerminal.nextLine();
                    System.out.println("Enter key location:");
                    String sKeyPath = kTerminal.nextLine();

                    System.out.println("Decoded message:");
                    System.out.println(Decryptor.DecryptMessageWithKey(sKeyPath,sMessagePath));
                    break;
                }
                case 4:{    // Exit
                    bRun = false;
                    break;
                }
                default:{
                    break;
                }
            }
        }

        //end. erase memory
    }

    //todo: move below files and ReadKeyFile into another class(es)
    /**
     * DisplayList - Outputs string array to command prompt
     * @param bNumbered True if list should be numbered, False for plain string text
     * @param sMessageList StringArray to print
     */
    private static void DisplayList(Boolean bNumbered, String[] sMessageList){

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
    private static int GetValidEntry(int iMin, int iMax){

        int iSelection = GetNumberFromTerminal();
        if(iSelection >= iMin && iSelection <= iMax){
            return  iSelection;
        }
        else {
            System.out.println("Number not in valid range, try again.");
            return GetValidEntry(iMin, iMax );
        }
    }

    private static int GetNumberFromTerminal(){
        // Information about reading from command window found here:
        // https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
        Scanner kTerminal = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        return kTerminal.nextInt();
    }

}
