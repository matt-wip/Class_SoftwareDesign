/*
    * Name: Matthew Wipfler
    * Date: 8/25/17
    * File: EncryptionManagement.java
    * Description: Provides an interface for creating and modifying encrypted files. Also can generate unique keys.
*/

import java.util.Scanner;

/**
 * Provides logic for creating/reading encrypted messages using files
 * @author Matt Wipfler
 */
public class EncryptionManagement {

    /**
     * Method to run for encryption program to work
     * Runs program through command line until user exits
     * @param args No necessary arguments
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
            TerminalInteraction.DisplayList(true, sMenuOptions);

            int iChoice = TerminalInteraction.GetValidEntry(1, sMenuOptions.length);
            switch (iChoice){
                case 1:{    // Create new key
                    System.out.println("Enter amount of numbers for key file:");
                    String sKeyPath = KeyGenerator.CreateNewKey(TerminalInteraction.GetValidEntry(0, 2147483647 ));
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
                    System.out.println("Enter key path:");
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
    }
}
