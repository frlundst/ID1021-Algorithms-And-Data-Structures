#include <stdio.h>
#include <stdlib.h>

/* 
* @author Fredrik Lundström
* 2021-09-21
* Task: Implement a function in C which takes an array of integers (both positive and negative) 
* and orders the elements in the array so that all negative elements come before the positive. 
* You are not allowed to sort the array (i.e. by any of the sorting methods) - only collect 
* all negative values first. The algorithm should only use O(1) extra memory.
*/

/* Main function with a for-loop that prints all values in the 
* array after function order has been called.
*/
int main(int argc, char *argv[]) {
	int array[] = {10, -2, 5, -1, -3, 5};
	int length = 6;
	order(array, length);
	
	int i;
	for(i = 0; i < length; i++){
		printf("%d,",array[i]);
	}
	
	return 0;
}

/* Function order takes an array and the length of the array and puts all
* of the negative numbers first in the array followed by the positive numbers.
* The for-loop loops for a total of 6 times in this case and every time there
* is an if-statement that checks if the value in the array is negative. If i = j
* it will not swap any values beacause that means it is the first value in the array.
* Integer j will always be behind i and array[j] will always be a positive number and switch
* values if array[i] is a negative number.
*/

/* Time complexity is O(n) since there is only one loop that goes through all of the elements.
* Uses only O(1) extra memory since a temporary variable for the exchange is needed.
*/
int order(int array[], int length){
	int i;
	int j = 0;
	int temporary;
	for(i = 0; i < length; i++){
		if(array[i] < 0){
			if(i != j){
				temporary = array[i];
				array[i] = array[j];
				array[j] = temporary;
			}
			j++;	
		}
	}
	return array;	
}
