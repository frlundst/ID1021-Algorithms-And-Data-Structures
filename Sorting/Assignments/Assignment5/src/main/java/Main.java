/**
 * @author Fredrik Lundström
 * 2021-09-24
 * Task: Experiment with the cut-off to insertionsort in mergesort. 
 * How is the execution time affected by different values for the cut-off? 
 * A suitable range for cut-off values to test with could be [0-30]. 
 * Upload code, tests and a graphs.
 */

import java.util.*;

/**
 * Main class with unit tests for user. User can input length of array
 * and integers will be randomized and put in the array.  
 */
public class Main {
    public static void main(String[] args) {
        int length, random_number, array[], expression, cut_off_value;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Length of array: ");
        length = scanner.nextInt();
        System.out.println("Enter cut-off value: ");
        cut_off_value = scanner.nextInt();
        array = new int[length];
        
        while(true){
            System.out.println("(1) Generate, (2) Merge, (3) Merge with insertion cutoff, (4) Merge and show, (5) Merge with insertion cutoff and show, (6) Enter cut-off value: , (7) Exit: ");
            expression = scanner.nextInt();
            
            switch(expression){
                case 1:
                    for(int i = 0; i < length; i++){
                        random_number = random.nextInt(50);
                        array[i] = random_number;
                    }
                    break;
                case 2:
                    Merge.sort(array, false, false, cut_off_value);
                    break;
                case 3:
                    Merge.sort(array, true, false, cut_off_value);
                    break;
                case 4:
                    Merge.sort(array, false, true, cut_off_value);
                    break;
                case 5:
                    Merge.sort(array, true, true, cut_off_value);
                    break;
                case 6:
                    System.out.println("Enter cut-off value: ");
                    cut_off_value = scanner.nextInt();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }  
    }
}
