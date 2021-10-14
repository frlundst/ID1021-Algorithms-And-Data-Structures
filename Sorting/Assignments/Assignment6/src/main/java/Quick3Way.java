/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author myfre
 */
public class Quick3Way {

    // This class should not be instantiated.
    private Quick3Way() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
        //assert isSorted(a);
        show(a);
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    private static void sort(int[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int lt = lo, gt = hi, cmp;
        int median = median(a, lo, hi);
        int v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            if(a[i] > v)
                cmp = 1;
            else if(a[i] < v)
                cmp = -1;
            else
                cmp = 0;
            //int cmp = a[i].compareTo(v);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
        //assert isSorted(a, lo, hi);
    }
    
    public static int median(int[] a, int lo, int hi){
        int c = (lo+hi)/2;
        int temp;
        
        if(a[lo] > a[c]){
            temp = lo;
            lo = c;
            c = temp;
        }
        if(a[lo] > a[hi]){
            temp = lo;
            lo = hi;
            hi = temp;
        }
        if(a[c] > a[hi]){
            temp = c;
            c = hi;
            hi = temp;
        }
        temp = c;
        c = hi;
        hi = temp;
        return a[hi];
    }

   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

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

