/*
    * Name: Matthew Wipfler
    * Date: 8/25/17
    * File: KeyGenerator.java
    * Description: Contains methods for key generation by a user and storing that key in a file
*/

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class KeyGenerator {


    /**
     * CreateNewKey - Generates a file of random ints (0-1000) with count n
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
            // Note: starting value is a random number between 1 and the Range
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
     * Opens, reads, and returns key values from a file
     * @param iStartingNumber Starting index in key file to read
     * @return Array of key values
     */
    public static int[] ReadKeyFile(String sKeyPath, int[] iStartingNumber){

        // Read in key file and index
        // sources: https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html
        // https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
        File kKeyFile = new File(sKeyPath);
        int[] iKeyValues = null;
        try{
            kKeyFile.createNewFile();
            BufferedReader kReader = new BufferedReader(new FileReader(kKeyFile));

            iStartingNumber[0] = Integer.parseInt(kReader.readLine());
            String[] sKeyValues = kReader.readLine().trim().split("\\s+");

            iKeyValues = new int[sKeyValues.length];
            for(int i = 0; i < sKeyValues.length; i++){
                iKeyValues[i] = Integer.parseInt(sKeyValues[i]);
            }
        }catch (Exception e){
            System.out.println("Error in reading key file: " + e.getMessage());
        }

        return iKeyValues;
    }


    public static void UpdateKeyIndex(String sKeyPath, int iNewKeyIndex){
        File kKeyFile = new File(sKeyPath);
        if(!kKeyFile.exists())
            return;

        try{
            // Read in existing key file
            Scanner kScanner = new Scanner(kKeyFile);
            kScanner.nextLine();
            String sSecondLineKeys = kScanner.nextLine();
            kScanner.close();

            // Update file
            FileWriter kWriter = new FileWriter(kKeyFile,false);
            kWriter.write(Integer.toString(iNewKeyIndex) + "\n");
            kWriter.write(sSecondLineKeys);
            kWriter.close();
        }catch(Exception e){
            System.out.println("Error updating key index: " + e.getMessage());
        }
    }

    /**
     * Creates an array of random integers between 1 and the Range
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
