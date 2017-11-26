import javax.swing.*;

/**
 * Driver class for file transfer. Based on fig28_07_10
 * @author Matt Wipfler
 */
public class ClientDriver {
    //28.13:: Use a socket connection to allow a client to specify a filename of a text file and have the server
    // send the contents of the file or indicate that the file does not exist.

    /**
     * Creates a simple server-client connection
     * @param args not used
     */
    public static void main(String[]args){
        Client client = new Client(); // create client
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.waitForPackets(); // run client application
    }
}