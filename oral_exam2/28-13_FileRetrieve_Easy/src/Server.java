// Fig. 28.7: Server.java
// Server side of connectionless client/server computing with datagrams.

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

/**
 * Server to find and return .txt files. Based on Server from fig28_07_10
 * @author modified by: Matt Wipfler
 */
public class Server extends JFrame {
    /** Text area to display message*/
    private JTextArea displayArea; // displays packets received
    /** Socket to connect to client*/
    private DatagramSocket socket; // socket to connect to client

    /**Constructor- set up GUI and DatagramSocket*/
    public Server() {
        super("Server");

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(400, 300); // set size of window
        setVisible(true); // show window

        try // create DatagramSocket for sending and receiving packets
        {
            socket = new DatagramSocket(5000);
        } catch (SocketException socketException) {
            socketException.printStackTrace();
            System.exit(1);
        }
    }

    /** wait for packets to arrive, find file, and echo file contents to client*/
    public void waitForPackets() {
        while (true) {
            try // receive packet, display contents, return copy to client
            {
                byte[] data = new byte[100]; // set up packet
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                socket.receive(receivePacket); // wait to receive packet

                String maybeFileName = new String(receivePacket.getData(),0, receivePacket.getLength());
                URL path = this.getClass().getResource(maybeFileName);
                File kFile = null;
                if(path!=null) kFile = new File(path.getPath());
                if(kFile!=null && kFile.exists()){
                    //https://stackoverflow.com/questions/28977308/read-all-lines-with-bufferedreader
                    try{
                        BufferedReader kreader = new BufferedReader(new FileReader(kFile),100);
                        String message;
                        while ((message = kreader.readLine())!= null) {
                            DatagramPacket kSend = new DatagramPacket(new byte[100], 100, receivePacket.getAddress(),receivePacket.getPort());
                            kSend.setData(message.getBytes());
                            sendPacketToClient(kSend);
                        }
                    }
                    catch (Exception e){
                        displayArea.append("Error sending packet to client: " +e.getMessage());
                    }
                }
                else{
                    String errorMessage = "Error: file not found\n";
                    sendPacketToClient(new DatagramPacket(errorMessage.getBytes(), errorMessage.getBytes().length, receivePacket.getAddress(), receivePacket.getPort())); // send packet to client
                }

            } catch (IOException ioException) {
                displayMessage(ioException + "\n");
                ioException.printStackTrace();
            }
        }
    }

    /**
     * Echo packet to client
     * @param receivePacket Object containing information to send to client
     * @throws IOException Sending packet failed
     */
    private void sendPacketToClient(DatagramPacket receivePacket) throws IOException {

        // create packet to send
        DatagramPacket sendPacket = new DatagramPacket(
                receivePacket.getData(), receivePacket.getLength(),
                receivePacket.getAddress(), receivePacket.getPort());

        socket.send(sendPacket); // send packet to client
    }

    /**
     * Manipulates displayArea in the event-dispatch thread
     * @param messageToDisplay Message to print to screen
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay); // display message
                    }
                }
        );
    }
}

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/