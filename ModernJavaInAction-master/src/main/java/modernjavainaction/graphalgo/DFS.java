package modernjavainaction.graphalgo;

import java.util.Arrays;

public class DFS {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private Graph g;

    public DFS(Graph g, int s) {
        this.s = s;
        this.g = g;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        Arrays.fill(edgeTo, -1);
        dfs(s);
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    // find all vertices connected to s
    private void dfs(int v){
        marked[v] = true;
        // for every vertice, that this vertice is connected to
        // get the vertice, if it is not marked, apply dfs
        for (int w: g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w]=v;
            }
        }

        for (int w: g.adj(v)) {
            if (!marked[w]) {

                dfs(w);
            }
        }
    }

}
