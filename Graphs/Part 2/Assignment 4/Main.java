import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        SymbolGraph symbolGraph = new SymbolGraph("data.txt");
        while(true){
            System.out.print("\nEnter a source vertex: ");
            String source = scanner.nextLine();
            DepthFirstPaths paths = new DepthFirstPaths(symbolGraph.G(), symbolGraph.index(source));
            System.out.print("Enter a target vertex: ");
            String target = scanner.nextLine();

            if(paths.marked(symbolGraph.index(target)))
                System.out.println(source + " has a path to " + target);
            else
                System.out.println("No path found betweeen " + source + " and " + target);
        }
    }
}

