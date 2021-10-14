/**
 * @author Fredrik Lundström
 * 2021-09-24
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
        if (hi <= lo)
            return;
        else{
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }
    }
    
    /**
     * mergesort a[lo..hi] using auxiliary array aux[lo..hi] with cutoff.
     * @param a
     * @param aux
     * @param lo
     * @param hi
     * @param cut_off_value 
     */
    private static void sortWithCutOff(int[] a, int[] aux, int lo, int hi, int cut_off_value) {
        if(hi <= lo + cut_off_value - 1){
            insertionSort(a, hi, lo);
        }   
        else{
            int mid = lo + (hi - lo) / 2;
            sortWithCutOff(a, aux, lo, mid, cut_off_value);
            sortWithCutOff(a, aux, mid + 1, hi, cut_off_value);
            merge(a, aux, lo, mid, hi);
        }
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a, boolean cutoff, boolean show, int cut_off_value) {
        int[] aux = new int[a.length];
        if(cutoff == false){
            long starttime = System.nanoTime();
            sort(a, aux, 0, a.length-1);
            System.out.println("Execution time: " + (System.nanoTime() - starttime)/1000000);
        }else{
            long starttime = System.nanoTime();
            sortWithCutOff(a, aux, 0, a.length-1, cut_off_value);
            System.out.println("Execution time: " + (System.nanoTime() - starttime)/1000000);
        }
        if(show == true)
            show(a);
    }
    
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param hi highest index
     * @param lo lowest index
     */
    public static void insertionSort(int[] a, int hi, int lo) {
        //int n = a.length;
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
