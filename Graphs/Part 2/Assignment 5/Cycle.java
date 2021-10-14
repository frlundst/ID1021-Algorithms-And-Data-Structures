public class Cycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle (if one exists)
    private boolean[] onStack; // vertices on recursive call stack

    public Cycle(Graph G) {
        onStack = new boolean[G.numberOfVertices()];
        edgeTo = new int[G.numberOfVertices()];
        marked = new boolean[G.numberOfVertices()];
        for (int v = 0; v < G.numberOfVertices(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    private void dfs(Graph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) //G.adj(v) returns all vertices connected to v
            if (this.hasCycle())
                return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) { //If it comes back to a vertice that is on the stack then it has made a cycle.
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
