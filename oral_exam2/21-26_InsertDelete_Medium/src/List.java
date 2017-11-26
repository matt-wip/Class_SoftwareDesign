// Fig. 21.3: List.java
// ListNode and List class declarations.

/** class to represent one node in a list*/
class ListNode<T> {
    // package access members; List can access these directly
    /**data for this node*/
    T data;
    /** reference to the next node in the list*/
    ListNode<T> nextNode;

    /** constructor creates a ListNode that refers to object
     * @param object data for new linklist node
     * */
    ListNode(T object) {
        this(object, null);
    }

    /**constructor creates ListNode that refers to the specified
    // object and to the next ListNode
     @param object data for new linklist node
     @param node next node of new node
     */
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    /**
     * Accessor. return reference to data in node
     * @return data of node
     */
    T getData() {
        return data;
    }

    /**
     * Accessor. return reference to next node in list
     * @return nextNode child of current node
     */
    ListNode<T> getNext() {
        return nextNode;
    }
} // end class ListNode<T>

/** class List definition*/
public class List<T> {
    /** reference to first node in list*/
    private ListNode<T> firstNode;
    /** reference to last node in list*/
    private ListNode<T> lastNode;
    /** string like "list" used in printing*/
    private String name;

    /** constructor creates empty List with "list" as the name*/
    public List() {
        this("list");
    }

    /**
     * constructor creates an empty List with a name
     * @param listName Name of the list
     */
    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    /**
     * Method to insert a node anywhere in a list
     * Assumes index is within bounds
     * @param n Node to insert into list
     * @param index index to insert at (0 to size-1)
     */
    public void insert(T n, int index){
        ListNode<T> current = firstNode;
        if(current==null || index == 0){
            insertAtFront(n);
            return;
        }

        ListNode<T> insertnode = new ListNode<T>(n);
        int count = 1;
        while(current.nextNode != null && count < index){
            count++;
            current = current.nextNode;
        }

        insertnode.nextNode = current.nextNode;
        current.nextNode = insertnode;
    }

    /**
     * insert item at front of List
     * @param insertItem Data to be inserted at node
     */
    public void insertAtFront(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // firstNode refers to new node
            firstNode = new ListNode<T>(insertItem, firstNode);
    }

    /**
     * insert item at end of List
     * @param insertItem Data to be inserted at node*/
    public void insertAtBack(T insertItem) {
        if (isEmpty()) // firstNode and lastNode refer to same object
            firstNode = lastNode = new ListNode<T>(insertItem);
        else // lastNode's nextNode refers to new node
            lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
    }

    /**
     * Method to remove any listnode in list
     * Assumes i is within the list length
     * @param i Index of desired element to return
     * @return data of node removed
     */
    public T remove(int i){
        if(isEmpty()) throw new EmptyListException(name);

        if(i==0)
            return removeFromFront();

        int index = 0;
        ListNode<T> current = firstNode;

        while(index < i-1 && current.nextNode != null){
            current = current.nextNode;
            index++;
        }
        ListNode<T> target = current.nextNode;
        if(target != null) {
            current.nextNode = target.nextNode;
            return target.data;
        }
        else{
            current.nextNode = null;
            return current.data;
        }
    }

    /** remove first node from List
     * @return data of removed node
     */
    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = firstNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else
            firstNode = firstNode.nextNode;

        return removedItem; // return removed node data
    } // end method removeFromFront

    /**
     *  remove last node from List
     *  @return  data of removed node
     */
    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) // throw exception if List is empty
            throw new EmptyListException(name);

        T removedItem = lastNode.data; // retrieve data being removed

        // update references firstNode and lastNode
        if (firstNode == lastNode)
            firstNode = lastNode = null;
        else // locate new last node
        {
            ListNode<T> current = firstNode;

            // loop while current node does not refer to lastNode
            while (current.nextNode != lastNode)
                current = current.nextNode;

            lastNode = current; // current is new lastNode
            current.nextNode = null;
        }

        return removedItem; // return removed node data
    }

    /**
     * determine whether list is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return firstNode == null; // return true if list is empty
    }

    /** output list contents*/
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        // while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }
} // end class List<T>

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
