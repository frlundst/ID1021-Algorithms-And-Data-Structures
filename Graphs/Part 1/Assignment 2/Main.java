import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        SymbolGraph symbolGraph = new SymbolGraph("data.txt");
        while(true){
            System.out.print("\nEnter a source vertex: ");
            String source = scanner.nextLine();
            BreadthFirstPaths paths = new BreadthFirstPaths(symbolGraph.G(), symbolGraph.index(source));
            System.out.print("Enter a target vertex: ");
            String target = scanner.nextLine();
            System.out.println("Path between " + source + " and " + target + " : ");
            for(int i : paths.pathTo(symbolGraph.index(target)))
                if(i == symbolGraph.index(source))
                    System.out.print(symbolGraph.name(i));
                else
                    System.out.print("-" + symbolGraph.name(i));
        }
    }
}

