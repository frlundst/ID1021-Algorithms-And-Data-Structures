import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        SymbolGraph symbolGraph = new SymbolGraph("data.txt");
        Cycle cycle = new Cycle(symbolGraph.G());
        System.out.println("Cycle? : " + cycle.hasCycle());
        
        for(int i : cycle.cycle()){
            System.out.println(symbolGraph.name(i) + " ");
        }
    }
}
