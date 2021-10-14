public class DepthFirstPaths {
    private boolean[] marked; //Marked vertices
    private int[] edgeTo; //remembers paths
    private final int s; //Source

    public DepthFirstPaths(Graph graph, int s){
        this.marked = new boolean[graph.numberOfVertices()];
        this.edgeTo = new int[graph.numberOfVertices()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v){
        this.marked[v] = true;
        for(int w : graph.adj(v)) //graph.adj(v) returns all vertices connected to v
            if(!this.marked[w]){
                edgeTo[w] = v; //v has a path to w
                dfs(graph, w);
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
