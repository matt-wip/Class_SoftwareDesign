// Fig. 28.9: Client.java
// Client side of connectionless client/server computing with datagrams.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Client to prompt server for file. Based on Server from fig28_07_10
 * @author modified by: Matt Wipfler
 */
public class Client extends JFrame {
    /** Text field for entering messages*/
    private JTextField enterField; // for entering messages
    /** Text area for displaying messages*/
    private JTextArea displayArea; // for displaying messages
    /** Socket to connect to server*/
    private DatagramSocket socket; // socket to connect to server

    /**Constructor- set up GUI and DatagramSocket*/
    public Client() {
        super("Client");

        enterField = new JTextField("Type message here");
        enterField.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        try // create and send packet
                        {
                            // get message from textfield
                            String message = event.getActionCommand();
                            byte[] data = message.getBytes(); // convert to bytes

                            // create sendPacket
                            DatagramPacket sendPacket = new DatagramPacket(data,
                                    data.length, InetAddress.getLocalHost(), 5000);

                            socket.send(sendPacket); // send packet
                            displayArea.setCaretPosition(
                                    displayArea.getText().length());
                        } catch (IOException ioException) {
                            displayMessage(ioException + "\n");
                            ioException.printStackTrace();
                        }
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(400, 300); // set window size
        setVisible(true); // show window

        try // create DatagramSocket for sending and receiving packets
        {
            socket = new DatagramSocket();
        } catch (SocketException socketException) {
            socketException.printStackTrace();
            System.exit(1);
        }
    }

    /** wait for packets to arrive from Server, display packet contents*/
    public void waitForPackets() {
        while (true) {
            try // receive packet and display contents
            {
                byte[] data = new byte[100]; // set up packet
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);

                socket.receive(receivePacket); // wait for packet

                // display packet contents
                displayMessage(new String(receivePacket.getData(),0, receivePacket.getLength()));
            }
            catch (IOException exception) {
                displayMessage(exception + "\n");
                exception.printStackTrace();
            }
        }
    }

    /** manipulates displayArea in the event-dispatch thread
     * @param messageToDisplay Message to print to text area
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay + "\n");
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
