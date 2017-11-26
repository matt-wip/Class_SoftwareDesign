/**
 * Driver class for project. Creates a random array and uses a merge sort algorithm to sort it
 * Psuedo code to base algorithm off of: https://www.toptal.com/developers/sorting-algorithms/merge-sort
 * @author Matt Wipfler
 */
public class MergeSort_Driver {

    /**
     * Main method to run. Creates random array, sorts it, then outputs resul
     * @param args not used
     */
    public static void main(String[] args) {
        // Create random value array
       int[] array = RandomArrayHelpers.generateRandomValues(100,1000);

       // Print initial values to screen
        System.out.println("Initial values:");
        RandomArrayHelpers.printArray(array);

        // Sort array using merge sort
        MergeSort.SortRecursively(array,0,array.length-1);

        // Print final array
        System.out.println("\nSorted values:");
        RandomArrayHelpers.printArray(array);
    }
}
