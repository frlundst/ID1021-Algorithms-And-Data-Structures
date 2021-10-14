/**
 * @author Fredrik Lundström
 * 2021-09-21
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
     * @param show calls method show if true
     */
    public static void sort(int[] a, boolean show) {
        int n = a.length;
        long starttime = System.nanoTime();
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
        System.out.println("Execution time: " + (System.nanoTime() - starttime)/1000000);
        if(show == true)
            show(a);
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
