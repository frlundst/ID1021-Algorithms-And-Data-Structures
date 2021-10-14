/**
 * @author Fredrik Lundström
 * A Main class that tests and executes code that use the stack class.
 * Written: 2021-09-14
 * Source: https://algs4.cs.princeton.edu/13stacks/
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		Scanner scanner = new Scanner(System.in);		

		while(true){		
			System.out.println("1: Iterative, 2: Recursive, 3: Is empty?, 4: Size, 5: Push, 6: Pop, 7: Peek, 8: To string, 9: Exit");
			int expression = scanner.nextInt();
			String temp = scanner.nextLine();
                        String text;
                        
			switch(expression){
					case 1: 
						text = scanner.nextLine();
						iterative(text, stack);
						break;
					case 2: 
						text = scanner.nextLine();
						recursive(text);
						break;
					case 3:	
						System.out.println(stack.isEmpty());
						break;
					case 4:
						System.out.println(stack.size());
						break;
					case 5: 			
						System.out.print("Type what you want to push: ");
						text = scanner.nextLine();		
						stack.push(text);
						System.out.println("Stack: " + stack);
						break;
					case 6: 
						stack.pop();
						System.out.println("Stack: " + stack);
						break;			
					case 7:
						System.out.println(stack.peek());
						break;
					case 8:
						stack.toString();
						break;
					case 9:
						System.exit(0);
			}
		}
	}

	/**
     	* A method that reverses and prints the input in reverse using iteration.
     	* 
     	* @param text text contains the input to be reversed.
        * @param stack the session stack
     	*/
	public static void iterative(String text, Stack<String> stack){
	        for(int i = 0; i < text.length(); i++){
	            stack.push(text.substring(i, i+1));
	        }
	        
	        for(String s : stack) {
	            System.out.print(s);
	        }
	}
    
        /**
     	* A method that reverses and prints the input in a recursive manner.
     	* @param text text contains the input to be reversed.
     	*/
    	public static void recursive(String text){
        	if(text.length() == 0) return;
        	recursive(text.substring(1));
        	System.out.print(text.charAt(0));
    	}   
}
