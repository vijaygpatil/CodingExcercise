package com.selfPractice.Graph2;

import java.util.LinkedList;

class GraphSLL {
    private int vertices; //number of vertices
    private LinkedList< Integer > adjacencyList[]; //Adjacency Lists

    @SuppressWarnings("unchecked")
    // Constructor
    public GraphSLL(int vertices) {
        vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }
    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdj() {
        return this.adjacencyList;
    }

    public static void main(String args[]) {
        GraphSLL g = new GraphSLL(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
    }
}