/**
 * @author Fredrik Lundström
 * 2021-09-20
 * Source: https://algs4.cs.princeton.edu/home/
 */

import java.util.*;

/**
 * Insertion class has methods such as sort that insertionsorts a given array.
 * Method less is a private method that compares if one value is less than the
 * other and returns true if it is less and false if it is equal or bigger.
 * Method exch is a private method that exchanges to values.
 * Method show is a private method that prints a given array.
 */
public class Insertion {
    
    // This class should not be instantiated.
    private Insertion() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     * Before exch is called there is a counter that increments and is later
     * printed thus printing the number of performed swaps.
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
