package com.selfPractice.Graph2;

public class RemoveEdge {

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);

        // remove edge 3 -> 4
        Object x = willCauseSeparateComponents(g, 3, 4);
        System.out.println("Separate components created due to deletion of edge 3 -> 4? " + x);

        // remove edge 1 -> 2
        x = willCauseSeparateComponents(g, 1, 2);
        System.out.println("Separate components created due to deletion of edge 1 -> 2? " + x);

    }

    private static boolean willCauseSeparateComponents(Graph g, int source, int destination) {
        g.getAdj()[source].remove(g.getAdj()[source].indexOf(destination));
        g.getAdj()[destination].remove(g.getAdj()[destination].indexOf(source));

        return isConnected(g);
    }

    private static boolean isConnected(Graph g) {
        int numOfVertices = g.getVertices();
        boolean visited[] = new boolean[numOfVertices];

        g.dfsTraversal(0, visited);

        for (int i = 0; i < numOfVertices; i++) {
            if(visited[i] == false)
                return false;
        }

        return true;
    }


}
