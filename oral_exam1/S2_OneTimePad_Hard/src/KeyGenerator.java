/*
    * Name: Matthew Wipfler
    * Date: 8/25/17
    * File: KeyGenerator.java
    * Description: Contains methods for key generation by a user and storing that key in a file
*/

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;

import static java.nio.file.StandardOpenOption.CREATE;

public class KeyGenerator {


    /**
     * CreateNewKey - Generates a file of random ints with length n
     * @param iNumberCount Length of random number list in key file
     * @return Full path of key file generated
     */
    public static String CreateNewKey(int iNumberCount){

        // Create string array of random integers
        int iRange = 1000; // range of values in random key generation. Default range is 1000
        int kKeyValues[] = GenerateRandomValues(iNumberCount, iRange);
        // Note: Range is 1000 for two reasons:
        // 1. Allows future additions of characters/symbols (not limited to 26)
        // 2. The key will be more difficult to interpret by someone looking to crack it

        // Using stream, output key to new file
        // Information about reading/writing files found at:
        // https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
        // https://docs.oracle.com/javase/tutorial/essential/io/file.html

        //todo: write more efficient. Merge try catches?
        // Create file
        File kKeyFile = new File("SecretKey.txt");
        try {
            kKeyFile.delete();
            kKeyFile.createNewFile(); // replaces file if already exists, or creates new if no file exists
        }
        catch (Exception e){
            System.out.println("Failed to create new key file: " + e.getMessage());
        }

        // Create output stream to file and write key to file
        try {
            OutputStream kOStream = Files.newOutputStream(kKeyFile.toPath(), CREATE);
            PrintWriter kPrinter = new PrintWriter(kOStream,true); // PrintWriter simplifies writing to file

            // Write starting value to file
            // Note: starting value is a random number between 1 and the Range1
            kPrinter.println((int)(Math.random() * iNumberCount));

            // Write key values to file
            for (int iValue: kKeyValues) {
                kPrinter.print(iValue);
                kPrinter.print(' ');
            }

            // Close streams (writes from buffer to file)
            kPrinter.close();
            kOStream.close();
        }catch (Exception e){
            System.out.println("Error in writing key to file: " + e.getMessage());
        }

        // Return file path
        if(kKeyFile.exists()){
            return kKeyFile.getAbsolutePath();
        }
        else {
            return ""; // File was not created
        }
    }

    /**
     * GenerateRandomValues - creates an array of random integers between 1 and the Range
     * @param iCount Length of random integer array
     * @return Random integer array
     */
    private static int[] GenerateRandomValues(int iCount, int iRange){

        // Create key array
        int kRandomValues[] = new int[iCount];

        // Store random values in array
        for (int i = 0; i < iCount; i++) {
            // Info about random found at: https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html
            kRandomValues[i] = (int)(Math.random() * iRange);
        }
        return kRandomValues;
    }
}
