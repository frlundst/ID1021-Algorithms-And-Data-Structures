/**
 * @author Fredrik Lundström
 * 2021-09-14
 * The user can test different cases through the console. 
 * Source: https://algs4.cs.princeton.edu/13stacks/
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        Scanner scanner = new Scanner(System.in);

	while(true){		
            System.out.println("1: Is empty?, 2: Size, 3: Peek, 4: Enqueue, 5: Dequeue, 6: Insert, 7: Remove, 8: To string, 9: Exit");
		int expression = scanner.nextInt();
                String temp = scanner.nextLine();
                String firstOrLast;
                String stringToInsert;
                
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
			String text = scanner.nextLine();
			queue.enqueue(text);
			System.out.println("Queue: " + queue);
			break;			
                    case 5:
                        System.out.println("Queue: " + queue.dequeue());
			break;
                    case 6:
                        firstOrLast = scanner.nextLine();
                        stringToInsert = scanner.nextLine();
                        queue.insert(firstOrLast, stringToInsert);
                        System.out.println("Queue: " + queue);
                        break;
                    case 7:
                        firstOrLast = scanner.nextLine();
                        queue.remove(firstOrLast);
                        System.out.println("Queue: " + queue);
                        break;
                    case 8:
                        System.out.println(queue.toString());
			break;
                    case 9:
			System.exit(0);
		}
	}
    }
}
