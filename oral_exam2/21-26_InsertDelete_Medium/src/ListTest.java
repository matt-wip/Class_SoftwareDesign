// Fig. 21.5: ListTest.java
// ListTest class to demonstrate List capabilities.
/**
 * Driver class to test list adding and subtracting
 * Based on ListTest from Fig 21.5.
 * @author Matt Wipfler
 */
public class ListTest {
    /** Main method to run
     * @param args not used
     */
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        // insert integers in list
        System.out.println("Using 'insert' to add node to at beginning:");  list.insert(5,0); list.print();
        System.out.println("Using 'insert' to add node at index 1:"); list.insert(2,1); list.print();
        System.out.println("Using 'insert' to add node at index 0:"); list.insert(8,0); list.print();
        System.out.println("Using 'insert' to add node at index 2:"); list.insert(4,2); list.print();
        System.out.println("Using 'insert' to add node at index 4:"); list.insert(9,4); list.print();

        // remove objects from list; print after each removal
        try {
            System.out.println("Removing index 4:"); list.remove(4); list.print();
            System.out.println("Removing index 2"); list.remove(2); list.print();
            System.out.println("Removing index 0");
            list.remove(0); list.print();
        } catch (EmptyListException emptyListException) {
            emptyListException.printStackTrace();
        }
    }
} // end class ListTest


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
