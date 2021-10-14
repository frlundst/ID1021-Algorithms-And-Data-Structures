/**
 * @author Fredrik Lundström
 * 2021-09-30
 */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        writeOnlyAlphaToFile();
        String[] stringarray =  toStringArray("onlyalpha.txt", 1000);
        BST<String, Integer> bst = new BST<String, Integer>();

        for(int i = 0; i < stringarray.length; i++){
            if(!bst.contains(stringarray[i]))
                bst.put(stringarray[i], 1);
            else
                bst.put(stringarray[i], bst.get(stringarray[i]) + 1);
        }
        
        String max = "";
        bst.put(max, 0); 
        long time = System.nanoTime();
        for (int i = 0; i < bst.size(); i++)
           if (bst.get(stringarray[i]) > bst.get(max))
                max = stringarray[i];
        time = System.nanoTime() - time;
        System.out.println("\nTable size: " + bst.size());
        System.out.println("Execution time: " + time);
        System.out.println(max + " " + bst.get(max));

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
