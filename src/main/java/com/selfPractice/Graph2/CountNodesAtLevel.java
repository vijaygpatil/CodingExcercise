package com.selfPractice.Graph2;

import java.util.Iterator;
import java.util.LinkedList;

class CountNodes {
    public static int numberOfNodesInGivenLevel(Graph g, int source, int level) {
        int count = 0;
        int num_of_vertices = g.getVertices();
        //Integer Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you add it into queue
        int visited[] = new int[num_of_vertices];
        //Create a linkedlist array called Queue
        LinkedList < Integer > queue = new LinkedList < Integer > ();
        //mark the visited nodes as true by setting value to 1 and add them to the queue
        visited[source] = 1;
        queue.add(source);
        //Traverse while queue is not empty
        while (queue.size() != 0) {
            //add the vertex/node from queue to result
            source = queue.poll();
            //Get adjacent vertices to the current node from the list
            LinkedList < Integer > Llist[];
            Llist = g.getAdj();
            Iterator < Integer > i = Llist[source].listIterator();

            while (i.hasNext()) {
                int temp = i.next();
                //if not already visited then add to the Queue
                if (visited[temp] != 1) {
                    visited[temp] = visited[source] + 1;
                    if (visited[temp] < level)
                        queue.add(temp);
                }
            }
        }
        //calculating the count for the level
        for (int i = 0; i < num_of_vertices; i++)
            if (visited[i] == level)
                count++;
        return count;
    }
}

class Main {
    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(2, 4);

        int answer;

        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 1);
        System.out.println(answer);
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 2);
        System.out.println(answer);
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 3);
        System.out.println(answer);
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 4);
        System.out.println(answer);
    }
}