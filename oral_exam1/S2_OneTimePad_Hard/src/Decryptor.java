/*
    * Name: Matthew Wipfler
    * Date: 8/26/17
    * File: CustomDecoder.java
    * Description: Contains methods decoding an encrypted file using a key file
*/

import java.io.*;

public class Decryptor {

    /**
     * Decrypt encrypted file
     * @param sKeyPath Full path of key file
     * @param sEncryptedPath Full path of encrypted message
     * @return Decrypted message from file
     */
    public static String DecryptMessageWithKey(String sKeyPath, String sEncryptedPath){

        int[] iKeyIndex = {0};
        int[] iKeyValues = KeyGenerator.ReadKeyFile(sKeyPath, iKeyIndex);

        // Check for encryped file
        String sDecodedMessage = "";
        File kEncryptedFile = new File(sEncryptedPath);
        if(!kEncryptedFile.exists()){
            return "Error in creating encrypted file";
        }

        // Decrypt file
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

    /**
     * Uses custom algorithm to decode character
     * @param iKeyValue Corresponding number from key file
     * @return "plain" character - decrypted
     */
    private static char DecryptOneLetter(char cEncryptedLetter, int iKeyValue){
        int iLetterIndex = Alphabet.ToNumber(cEncryptedLetter) - 1;
        int iValueAboveKey = 26 * (int)(Math.ceil(iKeyValue/26.0));
        return Alphabet.ToLetter(((iLetterIndex + iValueAboveKey - iKeyValue) % 26) + 1);
    }
}
