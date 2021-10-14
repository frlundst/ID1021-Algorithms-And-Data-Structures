/**
 * @author Fredrik Lundström
 * 2021-09-29
 * Write a simple filter to clean a text, i.e. to 
 * remove all characters that are not alphabetic, blank 
 * or newline - replacing every such character by a 
 * blank to keep the number of characters constant to 
 * the original text.
 */
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();

        char[] char_array = text.toCharArray();

        for(int i = 0; i < char_array.length; i++){
            if(isAlpha(char_array[i]) == false)
                char_array[i] = ' ';
        }
        
        text = String.valueOf(char_array);
        System.out.println("Text: " + text);
    }

    /**
     * This method returns the boolean value true if parameter c 
     * is alphabetical or false if not.
     * @param c is a character
     * @return true or false if c is alphabetical or non-alphabetical
     */
    private static Boolean isAlpha(char c){
        if((int)c >= 97 && (int)c <= 122 )
            return true;
        else
            return false;
    }
}
