package com.selfPractice.Graph2;

import java.util.Iterator;
import java.util.LinkedList;

public class CheckStronlyConnectedGraph {


    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

        Object x = CheckStronlyConnectedGraph.isStronglyConnected(g1);
        System.out.println("Graph g1 is strongly connected? " + x);


        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        x = CheckStronlyConnectedGraph.isStronglyConnected(g2);
        System.out.println("Graph g2 is strongly connected? " + x);
    }

    public static void utilityFunction(Graph g, int v, boolean visited[]) {
        visited[v] = true;
        int temp;
        LinkedList<Integer> LList[] = g.getAdj();
        Iterator<Integer> i = LList[v].listIterator();
        while(i.hasNext()) {
            temp = i.next();
            if(!visited[temp]) {
                utilityFunction(g, temp, visited);
            }
        }
    }

    private static Object isStronglyConnected(Graph g) {
        int numOfVertices = g.getVertices();
        boolean[] visited = new boolean[numOfVertices];

        for(int i = 0; i < numOfVertices; i++) {
            if(visited[i] == false) {
                return false;
            }
        }

        Graph g1 = g.getTranspose();

        for(int i = 0; i < numOfVertices; i++) {
            visited[i] = false;
        }


        for(int i = 0; i < numOfVertices; i++) {
            if(visited[i] == false) {
                return  false;
            }
        }

        return true;
    }
}
