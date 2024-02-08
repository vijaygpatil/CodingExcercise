package com.selfPractice.Graph2;

import java.io.*;
import java.util.*;

class Graph {
    private int vertices; //number of vertices
    private LinkedList < Integer > adjacencyList[]; //Adjacency Lists
    @SuppressWarnings("unchecked")
        // Constructor
    Graph(int vert) {
        this.vertices = vert;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < this.vertices; ++i)
            this.adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
    }

    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdj() {
        return this.adjacencyList;
    }

    void printGraph() {

        for (int v = 0; v < this.vertices; v++) {
            System.out.print(v);
            for (Integer pCrawl: this.adjacencyList[v]) {
                System.out.print("->" + pCrawl);
            }
            System.out.print("\n");
        }
    }

    public Graph getTranspose() {
        Graph g = new Graph(vertices);
        for (int i = 0; i < vertices; i++) {
            Iterator<Integer> iterator = adjacencyList[i].listIterator();
            while(iterator.hasNext()) {
                g.adjacencyList[iterator.next()].add(i);
            }
        }
        return g;
    }

    public void dfsTraversal(int v, boolean visited[]) {
        visited[v] = true;
        int source = 0;


        Iterator < Integer > i = adjacencyList[v].iterator();
        Integer temp;
        while (i.hasNext()) {
            temp = i.next();
            if (!visited[temp])
                dfsTraversal(temp, visited);
        }
    }
};
