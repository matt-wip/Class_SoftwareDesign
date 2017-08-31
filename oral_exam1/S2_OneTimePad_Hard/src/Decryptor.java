/*
    * Name: Matthew Wipfler
    * Date: 8/26/17
    * File: CustomDecoder.java
    * Description: Contains methods decoding an encrypted file using a key file
*/

import java.io.*;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.CREATE;

public class Decryptor {

    /**
     * @return Decrypted message from file
     */
    public static String DecryptMessageWithKey(String sKeyPath, String sEncryptedPath){

        int[] iKeyIndex = {0};
        int[] iKeyValues = ReadKeyFile(sKeyPath, iKeyIndex);

        // Decrypt file
        String sDecodedMessage = "";
        File kEncryptedFile = new File(sEncryptedPath);
        if(!kEncryptedFile.exists()){
            return "Error in creating encrypted file";
        }

        try{
            FileReader kFileReader = new FileReader(kEncryptedFile);
            BufferedReader kReader = new BufferedReader(kFileReader); // PrintWriter simplifies writing to file

            int iEncryptedKeyIndex = Integer.parseInt(kReader.readLine());
            String[] sEncryptedMessage = kReader.readLine().trim().split("\\s+");

            for(String sWord : sEncryptedMessage){
                for (char cLetter : sWord.toCharArray()) {
                    char cEncryptedLetter = DecryptOneLetter(cLetter,iKeyValues[iEncryptedKeyIndex % iKeyValues.length]);
                    sDecodedMessage += cEncryptedLetter;
                    iEncryptedKeyIndex++;
                }
                sDecodedMessage += ' ';
            }
            kReader.close();
            kFileReader.close();
        }catch(Exception e){
            System.out.println("Error in decrypting file: " + e.getMessage());
        }

        return sDecodedMessage;
    }

    private static char DecryptOneLetter(char cEncryptedLetter, int iKeyValue){
        int iLetterIndex = Alphabet.ToNumber(cEncryptedLetter) - 1;
        int iValueAboveKey = 26 * (int)(Math.ceil(iKeyValue/26.0));
        return Alphabet.ToLetter(((iLetterIndex + iValueAboveKey - iKeyValue) % 26) + 1);
    }

    /**
     * @param iStartingNumber Starting index in key file to read
     * @return Array of key values
     */
    private static int[] ReadKeyFile(String sKeyPath, int[] iStartingNumber){

        // Read in key file and index
        // sources: https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html
        // https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
        File kKeyFile = new File(sKeyPath);
        int[] iKeyValues = {999};
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
            System.out.println("Error in creating key file: " + e.getMessage());
        }

        return iKeyValues;
    }
}
