/**
 * @author Fredrik Lundström
 * 2021-10-04
 * Source: Algorithms Fourth Edition, Robert Sedgewick Kevin Wayne
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        writeOnlyAlphaToFile();
        int length = 139000;
        String[] stringarray =  toStringArray("onlyalpha.txt", length);

        BinarySearchST<String, Integer> table = new BinarySearchST<String, Integer>(length);
        for(int i = 0; i < stringarray.length; i++){
            if(!table.contains(stringarray[i])) 
                table.put(stringarray[i], 1);
            else
                table.put(stringarray[i], table.get(stringarray[i]) + 1);
                
        }
        table.show();
        
        int[] hashArray = new int[length];
        for(String s : table.keys()){
            int hash = (s.hashCode() & 0x7fffffff) % length; //Ska egentligen inte vara % length utan ska vara antalet olika ord.
            hashArray[hash]++;
        }

        int smallest = 0, largest = 0;
        for(int i : hashArray){
            System.out.print(i);
            if(largest < i)
                largest = i;
            if(smallest > i)
                smallest = i;        
        }

        System.out.println("\nLargest: " + largest + "\nSmallest: " + smallest);
    }

    public static String[] toStringArray(String filename, int numberOfWords)throws IOException{
        File thetext = new File(filename);
        Scanner scanner = new Scanner(thetext, "UTF-8");

        int counter = 0;
        String[] stringarray = new String[numberOfWords];

        while(scanner.hasNextLine()){
            Scanner scanner2 = new Scanner(scanner.nextLine());
            while(scanner2.hasNext() && counter < numberOfWords){ 
                stringarray[counter] = scanner2.next();
                counter++;
            }
        }
        scanner.close();
        return stringarray;
    }

    private static void writeOnlyAlphaToFile() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("98-0.txt"));
        FileWriter writer = new FileWriter("onlyalpha.txt");
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();

        while(line != null){
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        char[] char_array = stringBuilder.toString().toCharArray();

        for(int i = 0; i < char_array.length; i++){
            if(isAlpha(char_array[i]) == false)
                char_array[i] = ' ';
            else if((int) char_array[i] >= 65 && (int) char_array[i] <=90)
                char_array[i] = Character.toLowerCase(char_array[i]);
        }
        writer.write(String.valueOf(char_array));
        writer.close();
    }

    private static Boolean isAlpha(char c){
        if(((int)c >= 65 && (int)c <=90) || ((int)c >= 97 && (int)c <= 122 ))
            return true;
        else
            return false;
    }
}
