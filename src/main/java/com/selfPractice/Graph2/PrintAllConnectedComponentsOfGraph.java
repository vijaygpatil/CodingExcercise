package com.selfPractice.Graph2;

import java.util.LinkedList;

public class PrintAllConnectedComponentsOfGraph {

    public static void main(String args[]) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(3, 6);

        System.out.println("The connected components are:");
        printConnectedComponents(g);
    }

    private static void printConnectedComponents(Graph g) {
        int numOfVertices = g.getVertices();
        boolean visited[] = new boolean[numOfVertices];

        for (int i = 0; i < numOfVertices; i++) {
            if(!visited[i]){
                utilityFunction(g, i, visited);
            }
        }
    }

    private static void utilityFunction(Graph g, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        LinkedList<Integer> LList[] = g.getAdj();
        for(int i : LList[v]) {
            if(!visited[i]) {
                utilityFunction(g, i, visited);
            }
        }
    }
}
