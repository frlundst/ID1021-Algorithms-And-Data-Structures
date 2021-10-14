/**
 * @author Fredrik Lundström
 * 2021-09-21
 * Source: https://algs4.cs.princeton.edu/home/
 */

public class Merge {

    // This class should not be instantiated.
    private Merge() { }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              
                a[k] = aux[j++];
            else if (j > hi)               
                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) 
                a[k] = aux[j++];
            else                           
                a[k] = aux[i++];
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param show calls method show if true
     */
    public static void sort(int[] a, boolean show) {
        int[] aux = new int[a.length];
        long starttime = System.nanoTime();
        sort(a, aux, 0, a.length-1);
        System.out.println("Execution time: " + (System.nanoTime() - starttime)/1000000);
        if(show == true)
            show(a);
    }

   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
