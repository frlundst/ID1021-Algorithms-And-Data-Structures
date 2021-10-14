/**
 * @author Fredrik Lundström
 * 2021-09-20
 * Task: Basis for assignments 1 and 2: Implement insertionsort. Augment the 
 * sorting process so that all the content of the array that is being sorted is 
 * printed after each inner loop iteration. Write a unit test in main() which 
 * allows the user to define the size of the input (N) and then input (N) 
 * integers from stdin which is to be sorted. Add a method which counts the 
 * number of inversions in the input array and prints a list of all inversions 
 * on the format [i,a[i]], [j, a[j]] where i and j are indices and a[i], a[j] 
 * are the values of the elements. Call the method from main() before the array 
 * is sorted. Calculate the time complexity for the algorithm.
 */

import java.util.*;

/**
 * Main class with unit tests for user. User can input length of array
 * and integers to the array. 
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Size of input: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Integers to be sorted: ");
        
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        
        System.out.println("Number of inversions: " + Insertion.numberOfInversions(array));
        Insertion.sort(array);
    }
}
