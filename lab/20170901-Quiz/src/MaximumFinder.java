// Fig. 6.3: MaximumFinder.java
// Programmer-declared method maximum with three double parameters.

public class MaximumFinder {

    // returns the maximum of its three double parameters
    public static double maximum(double x, double y, double z) {
        double maximumValue = x; // assume x is the largest to start

        // determine whether y is greater than maximumValue
        if (y > maximumValue)
            maximumValue = y;

        // determine whether z is greater than maximumValue
        if (z > maximumValue)
            maximumValue = z;

        return maximumValue;
    }
} // end class MaximumFinder

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
