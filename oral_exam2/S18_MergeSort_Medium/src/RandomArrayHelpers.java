/** Class for creating a random array and other useful methods*/
public class RandomArrayHelpers
{
        /**
         * Create array with random integers
         * @param length number of entries in array
         * @param range max value of an entry in the array
         * @return array filled with random values
         */
    public static int[] generateRandomValues(int length, int range) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            // generate value between 0 and range
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }

    /**
     * Prints the array to system out
     * @param arr integer array to print
     */
    public static void printArray(int[] arr){
        for (int i:arr) {
            System.out.print(i + ", ");
        }
    }
}
