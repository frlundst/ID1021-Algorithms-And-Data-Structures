#include <stdio.h>
#include <stdlib.h>
/*
	@Author Fredrik Lundström
	2021-09-14
	Function iterative takes 5 values until newline is hit (enter) and stores
	the values in an array. Then a for-loop prints the array reversed.
	Function recursive takes unlimited amounts of values until newline is hit (enter).
	Then the values get printed in reverse.
	
*/
int main(int argc, char *argv[]) {
	//iterative();
	recursive();
	return 0;
}

void iterative(){
	int str[5];
	int i = 0;
	
	while(i < 5 && (str[i] = getchar()) != '\n'){
		i++;
	}
	if(str[i] == '\n') //If newline
		for(i = 5; i >= 0; i--){ //For-loop that prints characters reversed
			putchar(str[i]);
		}
}

void recursive(){
	int c;
	if((c = getchar()) != '\n'){
		recursive();
		putchar(c);
	}
}
