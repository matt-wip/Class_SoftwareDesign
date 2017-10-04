/*
    * Name: Matthew Wipfler
    * Date: 8/26/17
    * File: CustomEncoder.java
    * Description: Contains methods for encoding a string message from a key file
*/

import java.io.*;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.CREATE;

public class Encryptor {

    /**
     * Encodes message based on key file and outputs to a new file
     * @param sKeyPath Full path of key file
     * @param sMessage User inputted message to encode
     * @return Path of encrypted message file
     */
    public static String EncryptMessageWithKey(String sKeyPath, String sMessage){

        int[] iKeyIndex = {0};
        int[] iKeyValues = KeyGenerator.ReadKeyFile(sKeyPath, iKeyIndex);

        // Encrypt file
        File kEncryptedMessage = new File("EncryptedMessage.txt");
        try{
            kEncryptedMessage.delete();
            kEncryptedMessage.createNewFile();
            if(!kEncryptedMessage.exists()){
                return "Error in creating encrypted file";
            }

            OutputStream kOStream = Files.newOutputStream(kEncryptedMessage.toPath(), CREATE);
            PrintWriter kPrinter = new PrintWriter(kOStream,true); // PrintWriter simplifies writing to file

            kPrinter.println(iKeyIndex[0]);
            for (char cLetter : sMessage.toCharArray()) {
                if(Character.isWhitespace(cLetter)){
                    kPrinter.print(' ');
                }
                else{
                    char cEncryptedLetter = EncryptOneLetter(cLetter,iKeyValues[iKeyIndex[0]]);
                    kPrinter.print(cEncryptedLetter);
                    iKeyIndex[0] = (iKeyIndex[0]+1) % iKeyValues.length;
                }
            }
            kPrinter.close();
            kOStream.close();
        }catch(Exception e){
            System.out.println("Error in writing encrypted file: " + e.getMessage());
        }

        KeyGenerator.UpdateKeyIndex(sKeyPath, iKeyIndex[0]);

        return kEncryptedMessage.getAbsolutePath();
    }

    /**
     * Uses a custom encoding algorithm to transform one character
     * @param c Character to encode
     * @param iKeyValue Number to use in encryption algorithm
     * @return Encrypted letter
     */
    private static char EncryptOneLetter(char c, int iKeyValue){
        return Alphabet.ToLetter((iKeyValue + Alphabet.ToNumber(c) - 1) % 26 + 1);
    }

}
