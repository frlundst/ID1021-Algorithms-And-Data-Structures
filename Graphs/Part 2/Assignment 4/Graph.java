import java.io.*;
import java.util.*;

public class Graph {
    private final int numberOfVertices;
    private int numberOfEdges;
    private Stack<Integer>[] adj; //adjacency lists

    public Graph(int numberOfVertices){
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = 0;
        adj = (Stack<Integer>[]) new Stack[numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++)
            adj[i] = new Stack<Integer>();
    }

    /*public Graph(Scanner scanner) throws IOException{
        this(scanner.nextInt());
        System.out.print("Number of edges; ");
        int E = scanner.nextInt();
        for(int i = 0; i < E; i++){
            System.out.print("(" + i + ") Enter vertex: ");
            int vertex = scanner.nextInt();
            System.out.print("(" + i + ") Enter another vertex: ");
            int anotherVertex = scanner.nextInt();
            addEdge(vertex, anotherVertex);
        }
    }*/

    public void addEdge(int vertex, int anotherVertex){
        this.adj[vertex].push(anotherVertex);
        this.numberOfEdges++;
    }

    public Graph reverse(){
        Graph reverse = new Graph(numberOfVertices);
        for (int vertex = 0; vertex < numberOfVertices; vertex++)
            for (int anotherVertex : adj(vertex))
                reverse.addEdge(anotherVertex, vertex);
        return reverse;
    }

    public int numberOfVertices(){
        return this.numberOfVertices;
    }

    public int numberOfEdges(){
        return this.numberOfEdges;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString(){
        String s = this.numberOfVertices + "vertices, " + this.numberOfEdges + " edges\n";
        for(int i = 0; i < this.numberOfVertices; i++){
            s += i + ": ";
            for(int j : this.adj(i))
                s += j + " ";
            s += "\n";
        }
        return s;
    }
}
