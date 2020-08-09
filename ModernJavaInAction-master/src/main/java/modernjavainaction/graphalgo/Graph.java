package modernjavainaction.graphalgo;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Integer>[] graphData;
    private final int vertices;

    public Graph(int vertices) {

        this.vertices = vertices;
        graphData = new HashSet[vertices];
        for (int v = 0; v<vertices; v++) {
            graphData[v] = new HashSet<>();
        }
    }

    public void addEdge(int v, int w) {
        graphData[v].add(w);
        graphData[w].add(v);
    }

    public int V() {
        return vertices;
    }

    public Iterable<Integer> adj(int v) {
        return graphData[v];
    }

}
