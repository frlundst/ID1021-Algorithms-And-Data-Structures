public class DepthFirstPaths {
    private boolean[] marked;

    public DepthFirstPaths(Graph graph, int s){
        this.marked = new boolean[graph.numberOfVertices()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v){
        this.marked[v] = true;
        for(int w : graph.adj(v))
            if(!this.marked[w])
                dfs(graph, w);
    }

    public boolean hasPathTo(int y){
        return this.marked[y];
    }

    /*public Iterable<Integer> pathTo(int y){
        if (!hasPathTo(y))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = y; x!= this.s; x = edgeTo[x])
            path.push(x);
        path.push(this.s);
        return path;
    }*/

    public boolean marked(int v){
        return marked[v];
    }
}
