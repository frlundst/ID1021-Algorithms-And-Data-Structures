import java.util.*;
import java.io.*;

public class SymbolGraph {
    private ST<String, Integer> st; // String -> index
    private String[] keys; // index -> String
    private Graph G; // the graph
    
    public SymbolGraph(String filename) throws IOException {
        st = new ST<String, Integer>();
        String[] a = toStringArray(filename, 214);

        for (int i = 0; i < a.length; i++) // to associate each
            if (!st.contains(a[i])) // distinct string
                st.put(a[i], st.size()); // with an index.
        
        keys = new String[st.size()]; // Inverted index
        for (String name : st.keys()) // to get string keys
            keys[st.get(name)] = name; // is an array.
        
        G = new Graph(st.size());
        //int v = st.get(a[0]); // first vertex
        for (int i = 0; i < a.length; i++) // on each line
            G.addEdge(st.get(a[i]), st.get(a[++i])); // to all the others.
    }

    public static String[] toStringArray(String filename, int numberOfWords)throws IOException{
        File thetext = new File(filename);
        Scanner scanner = new Scanner(thetext, "UTF-8");

        int counter = 0;
        String[] stringarray = new String[numberOfWords];

        while(scanner.hasNextLine()){
            Scanner scanner2 = new Scanner(scanner.nextLine());
            while(scanner2.hasNext()){
                stringarray[counter] = scanner2.next();
                counter++;
            }
        }
        scanner.close();
        return stringarray;
    }

    public boolean contains(String s) { return st.contains(s); }
    public int index(String s) { return st.get(s); }
    public String name(int v) { return keys[v]; }
    public Graph G() { return G; }
}
