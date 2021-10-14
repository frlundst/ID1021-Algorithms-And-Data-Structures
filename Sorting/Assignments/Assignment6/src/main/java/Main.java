/**
 * @author Fredrik Lundström
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int length, random_number, array[], expression, cut_off_value;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Length of array: ");
        length = scanner.nextInt();
        array = new int[length];
        
        while(true){
            System.out.println("(1) Generate, (2) Quicksort, (3) Quicksort and show, (4) Exit: ");
            expression = scanner.nextInt();
            
            switch(expression){
                case 1:
                    for(int i = 0; i < length; i++){
                        random_number = random.nextInt(50);
                        array[i] = random_number;
                    }
                    break;
                case 2:
                    Quick.sort(array, false);
                    break;
                case 3:
                    Quick.sort(array, true);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }  
    }
}
