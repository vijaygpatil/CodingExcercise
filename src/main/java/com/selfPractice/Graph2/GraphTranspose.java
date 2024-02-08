package com.selfPractice.Graph2;

import java.util.LinkedList;

public class GraphTranspose {
    public static void getTranspose(Graph g) {
        int numOfVertices = g.getVertices();
        Graph transposedGraph = new Graph(numOfVertices);
        LinkedList<Integer> Llist[] = g.getAdj();
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < Llist[i].size(); j++) {
                transposedGraph.addEdge(Llist[i].get(j), i);
            }
        }

        transposedGraph.printGraph();
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        System.out.println("Transpose of given Graph: ");
        getTranspose(g1);
    }
}
