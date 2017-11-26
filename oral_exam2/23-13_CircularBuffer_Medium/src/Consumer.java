// Fig. 23.11: Consumer.java
// Consumer with a run method that loops, reading 10 values from buffer.

import java.security.SecureRandom;

/**
 * Class from Fig23_18-19 example
 */
public class Consumer implements Runnable {
    /** Random value generator*/
    private static final SecureRandom generator = new SecureRandom();
    /**reference to shard object*/
    private final Buffer sharedLocation;

    /**constructor
     * @param sharedLocation Buffer for consumer to get data from*/
    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    /** read sharedLocation's value 10 times and sum the values*/
    public void run() {
        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            // sleep 0 to 3 seconds, read value from buffer and add to sum
            try {
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.blockingGet();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

       // System.out.printf("%n%s %d%n%s%n","Consumer read values totaling", sum, "Terminating Consumer");
    }
} // end class Consumer


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
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