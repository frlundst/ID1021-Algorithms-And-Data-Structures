/**
 * @author Fredrik Lundström
 * 2021-09-14
 * The user can test different cases through the console. 
 * Source: https://algs4.cs.princeton.edu/13stacks/
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
    Queue<Integer> queue = new Queue<Integer>();
    Scanner scanner = new Scanner(System.in);
        
	while(true){		
            System.out.println("1: Is empty?, 2: Size, 3: Peek, 4: Insert, 5: Delete kth element, 6: To string, 7: Exit");
            int expression = scanner.nextInt();
            String temp = scanner.nextLine();
            switch(expression){
                case 1:	
                    System.out.println(queue.isEmpty());
                    break;
                case 2:
                    System.out.println(queue.size());
                    break;
                case 3: 			
                    System.out.println(queue.peek());
                    break;
                case 4: 
                    int value = scanner.nextInt();
                    queue.insert(value);
                    System.out.println("Queue: " + queue);
                    break;	
                case 5:
                    int k = scanner.nextInt();
                    queue.delete(k);
                    System.out.println("Queue: " + queue);
                    break;
                case 6:
                    System.out.println(queue.toString());
                    break;
                case 7:
                    System.exit(0);
            }
	}
    }
}
