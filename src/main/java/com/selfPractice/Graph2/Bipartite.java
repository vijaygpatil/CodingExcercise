package com.selfPractice.Graph2;

public class Bipartite {

    public static void main(String args[]) {

        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 1);


        Graph g2 = new Graph(7);
        g2.addEdge(3, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 1);
        g2.addEdge(5, 3);
        g2.addEdge(6, 2);
        g2.addEdge(3, 1);

        boolean[] discovered = new boolean[8];
        boolean[] color = new boolean[8];
        discovered[1] = true;
        color[1] = false;


        //Example 1
        Object x = Bipartite.isBipartite(g, 1, discovered, color);
        System.out.println("Graph1 is bipartite: " + x);


        //Example 2
        x = Bipartite.isBipartite(g2, 1, discovered, color);
        System.out.println("Graph2 is bipartite: " + x);
        
    }

    private static Object isBipartite(Graph g, int source, boolean[] visited, boolean[] color) {

        for(int u : g.getAdj()[source]) {
            if(visited[u] == false) {
                visited[u] = true;
                color[u] = !color[source];

                if(String.valueOf(isBipartite(g, u, visited, color)) == "false") {
                    return false;
                }
            } else if (color[source] == color[u]) {
                return false;
            }
        }
        return true;
    }
}
