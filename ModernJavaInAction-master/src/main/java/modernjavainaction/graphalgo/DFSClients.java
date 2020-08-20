package modernjavainaction.graphalgo;

import org.junit.Test;

public class DFSClients {
    public static void main(String[] args) {
        dfs_Client_1();
    }

    public static void dfs_Client_1(){
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,3);
        g.addEdge(1,3);
        DFS dfs = new DFS(g,3);
        int[] edges = dfs.getEdgeTo();
        int deb = 3;
    }

    @Test
    public void bfs_Client(){


    }
}
