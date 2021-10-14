public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo; //remembers paths
    private final int s; //source

    public BreadthFirstPaths(Graph graph, int s){
        this.marked = new boolean[graph.numberOfVertices()];
        this.edgeTo = new int[graph.numberOfVertices()];
        this.s = s;
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s){
        Queue<Integer> queue = new Queue<Integer>();
        this.marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w : graph.adj(v)) //graph.adj(v) returns all vertices connected to v
                if (!marked[w]){
                    edgeTo[w] = v; //v is connected to w
                    marked[w] = true;
                    queue.enqueue(w);
                }
        } 
    }

    public boolean hasPathTo(int y){
        return this.marked[y];
    }

    public Iterable<Integer> pathTo(int y){
        if (!hasPathTo(y))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = y; x!= this.s; x = edgeTo[x])
            path.push(x);
        path.push(this.s);
        return path;
    }
}
