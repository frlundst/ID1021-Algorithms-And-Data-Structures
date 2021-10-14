/**
 * @author Fredrik Lundström
 * 2021-09-20
 * Source: https://algs4.cs.princeton.edu/home/
 */

import java.util.*;

public class Insertion {
    // This class should not be instantiated.
    private Insertion() { }
    
    /**
     * The two for-loops will together compare one elements with all the
     * elements after that element just as the insertionsort algorithm. Then
     * there is an if-statement that checks if the element (i) is bigger than
     * one of the other elements and therefore a swap is needed for those two
     * elements in the sort method.
     * There are approximately n*n/2 iterations performed in this method 
     * since j = i + 1 but n -> ∞ so constant can be disregarded. Therefore
     * the time complexity of this algorithm is O(n^2).
     * @param a is the array with unsorted elements
     * @return 
     */
    public static int numberOfInversions(int[] a){
        int counter = 0, n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(a[i] > a[j])
                    System.out.println("[" + i + "," + a[i] + "]" + "," + "["
                    + j + "," + a[j] + "]");
                    counter++;
            }
        }
        return counter;
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        int n = a.length;
        int counter = 0; 
        show(a);
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                counter++;
                exch(a, j, j-1);
                show(a);
            }
        }
        System.out.println("Number of swaps: " + counter);
    }

   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/

   // print array to standard output
    private static void show(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if(i != (a.length - 1))
                System.out.print(",");
        }
        System.out.println("]");
    }
}
