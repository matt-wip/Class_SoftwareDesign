import java.util.Arrays;
/**
 * Class for implementing merge sort algorithm
 * Based on: https://www.toptal.com/developers/sorting-algorithms/merge-sort
 * @author Matt Wipfler
 */
public class MergeSort {

    /**
     * Merge sort algorithm
     * @param arr array to sort recursively
     * @param startIndex index in array to start iteration
     * @param endIndex index in array to end iteration
     */
    public static void SortRecursively(int[] arr, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;

        // split in half
        int m = (endIndex-startIndex)/2 + startIndex;

        // recursive sorts
        SortRecursively(arr,startIndex,m);
        SortRecursively(arr,m+1,endIndex);

        int[] b = Arrays.copyOfRange(arr,0,arr.length);
        int i = 0; int j = m+1; int k = 0;
        while(i <= m && j<= endIndex){
            arr[k++] = (arr[j]<b[i]) ? arr[j++] : b[i++];
        }
        while(i <= m){
            arr[k++] = b[i++];
        }
    }
}
