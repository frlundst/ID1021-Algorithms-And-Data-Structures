/**
 * @author Fredrik Lundström
 * 2021-09-20
 * Task: Augment the test code from assignment 1&2 so that the array is sorted 
 * in descending order instead of ascending order (you may add O(N) operations) 
 * Clarification: You should not change (not alter/modify any code in) the 
 * sorting method, nor should you sort the array an extra time. 
 * You may traverse the array once before sorting and once after sorting. 
 * During these traversals you may not move (re-order) any elements. 
 * (Hint: you need not and should not use any extra memory)
 */

import java.util.*;

/**
 * Main class with unit tests for user. User can input length of array
 * and integers.  
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Size of input: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Integers to be sorted: ");
        
        for(int i = 0; i < n; i++){
            array[i] = -scanner.nextInt();
        }
        
        Insertion.sort(array);
        for(int i = 0; i < n; i++){
            array[i] = -array[i];
        }
        System.out.print("[");
        for(int i = 0; i < n; i++){
            System.out.print(array[i]);
            if(i != (array.length - 1))
                System.out.print(",");
        }
        System.out.print("]");
    }
}
