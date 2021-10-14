import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        SymbolGraph symbolGraph = new SymbolGraph("data.txt");
        while(true){
            System.out.print("\nEnter a source vertex: ");
            String source = scanner.nextLine();
            BreadthFirstPaths paths1 = new BreadthFirstPaths(symbolGraph.G(), symbolGraph.index(source));
            System.out.print("Enter a intermediate vertex: ");
            String intermediate = scanner.nextLine();
            BreadthFirstPaths paths2 = new BreadthFirstPaths(symbolGraph.G(), symbolGraph.index(intermediate));
            System.out.print("Enter a target vertex: ");
            String target = scanner.nextLine();
            if(paths1.hasPathTo(symbolGraph.index(intermediate)) && paths2.hasPathTo(symbolGraph.index(target))){
                for(int i : paths1.pathTo(symbolGraph.index(intermediate)))
                    if(i == symbolGraph.index(source))
                        System.out.print(symbolGraph.name(i));
                    else
                        System.out.print("-" + symbolGraph.name(i));

                for(int i : paths2.pathTo(symbolGraph.index(target)))
                    if(i == symbolGraph.index(source))
                        System.out.print(symbolGraph.name(i));
                    else
                        System.out.print("-" + symbolGraph.name(i));
            }
        }
    }
}

