import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        writeOnlyAlphaToFile();
        String[] stringarray =  toStringArray("onlyalpha.txt", 1000);
        SeparateChainingHashST<String, Integer> separateChainingHashST = new SeparateChainingHashST<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < stringarray.length; i++){
            if(!separateChainingHashST.contains(stringarray[i]))
                separateChainingHashST.put(stringarray[i], 1);
            else
                separateChainingHashST.put(stringarray[i], separateChainingHashST.get(stringarray[i]) + 1);
        }
        while(true){
            System.out.println("Check word: ");
            String key = scanner.nextLine();
            if(separateChainingHashST.contains(key))
                System.out.println(key + " appears " + separateChainingHashST.get(key) + " times.");
            else
                System.out.println("Table does not contain " + key);
        }
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
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/f/r/frlundst/Desktop/ID1021-Lab-3-Searching-main/Assignments/Assignment 6/98-0.txt"));
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
