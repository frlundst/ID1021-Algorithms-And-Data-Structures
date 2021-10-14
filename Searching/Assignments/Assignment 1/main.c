#include <stdio.h>
#include <stdlib.h>

/*
	@Author Fredrik Lundström
	2021-09-28
    Write a simple filter to clean a text, i.e. to remove all 
    characters that are not alphabetic, blank or newline - replacing 
    every such character by a blank to keep the number of characters 
    constant to the original text.
*/

int main(int argc, char *argv[]){
    int c;
    readfromfile(c);
}

/*
    Functino readfromfile reads the text from a file instead of input 
    input in the terminal and writes it in a new text file but with
    only alphabetical characters.
*/
void readfromfile(int c){
    FILE * file;
    file = fopen("thetext.txt", "r");

    FILE * newfile;
    newfile = fopen("onlyalpha.txt", "w");

    int i = 0;
    while((c = getc(file)) != EOF){
        if(isalpha(c) == 0)
            c = NULL;
        else
            fputc(c, newfile);
        i++;
    }
    fclose(file);
    fclose(newfile);
}

void readfromterminal(int c){
    while((c = getchar()) != '\n'){
        if(isalpha(c) == 0)
            c = NULL;
    }
    putchar(c);
}