/**
 * @author Fredrik Lundström
 * 2021-09-21
 * Compare the execution times for sorting large arrays of integers with 
 * insertionsort,merge sort and quicksort. When should one select one method 
 * over the others? Upload code, tests and a graphs depicting the execution 
 * times as a function of input (what parameters in the input could be relevant?). 
 * (you need to test for a range of input sizes).
 */

import java.util.*;

/**
 * Main class with unit tests for user. User can input length of array
 * and integers will be randomized and put in the array.  
 */
public class Main {
    public static void main(String[] args) {
        int length, random_number, array[], expression;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Length of array: ");
        length = scanner.nextInt();
        array = new int[length];
        
        while(true){       
            System.out.println("(1) Insertion, (2) Merge, (3) Quick, (4) Insertion and show, (5) Merge and show, (6) Quick and show, (7) Generate, (8) Length, (9) Exit : ");
            expression = scanner.nextInt();
            
            switch(expression){
                case 1:
                    Insertion.sort(array, false);
                    break;
                case 2:
                    Merge.sort(array, false);
                    break;
                case 3:
                    Quick.sort(array, false);
                    break;
                case 4:
                    Insertion.sort(array, true);
                    break;
                case 5:
                    Merge.sort(array, true);
                    break;
                case 6:
                    Quick.sort(array, true);
                    break;
                case 7:
                    for(int i = 0; i < length; i++){
                        random_number = random.nextInt(50);
                        array[i] = random_number;
                    }
                    break;
                case 8:
                    System.out.println("Length of array: ");
                    length = scanner.nextInt();
                    array = new int[length];
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }
}
