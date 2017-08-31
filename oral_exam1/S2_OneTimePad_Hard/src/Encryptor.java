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
     * @return Path of encrypted message file
     */
    public static String EncryptMessageWithKey(String sKeyPath, String sMessage){

        int[] iKeyIndex = {0};
        int[] iKeyValues = ReadKeyFile(sKeyPath, iKeyIndex);

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
                    continue;
                }
                char cEncryptedLetter = EncryptOneLetter(cLetter,iKeyValues[iKeyIndex[0]%iKeyValues.length]);
                kPrinter.print(cEncryptedLetter);
                iKeyIndex[0]++;
            }
            kPrinter.close();
            kOStream.close();
        }catch(Exception e){
            System.out.println("Error in writing encrypted file: " + e.getMessage());
        }

        //todo: update key index (iKeyIndex value)

        return kEncryptedMessage.getAbsolutePath();
    }

    private static char EncryptOneLetter(char c, int iKeyValue){
        return Alphabet.ToLetter((iKeyValue + Alphabet.ToNumber(c) - 1) % 26 + 1);
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
            System.out.println("Error in creating key file: " + e.getMessage());
        }

        return iKeyValues;
    }
}
