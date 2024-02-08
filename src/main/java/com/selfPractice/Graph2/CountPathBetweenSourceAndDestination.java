package com.selfPractice.Graph2;

import java.util.LinkedList;

public class CountPathBetweenSourceAndDestination {
    public static int countPaths(Graph g, int start, int destination) {
        int count = 0;
        return countPathRecursive(g, start, destination, count);
    }

    private static int countPathRecursive(Graph g, int start, int destination, int count) {
        LinkedList<Integer> LList[] = g.getAdj();
        if(start == destination) {
            count++;
        } else {
            for (int i = 0; i < LList[start].size(); i++) {
                int ajdacentVertex = LList[start].get(i);
                count = countPathRecursive(g, ajdacentVertex, destination, count);
            }
        }
        return count;
    }

    public static void main(String args[]) {

        int answer;
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 3);
        g1.addEdge(4, 5);

        answer = CountPathBetweenSourceAndDestination.countPaths(g1, 0, 5);
        System.out.println(answer);

        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 5);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(5, 3);
        g2.addEdge(5, 6);
        g2.addEdge(3, 6);

        answer = CountPathBetweenSourceAndDestination.countPaths(g2, 0, 3);
        System.out.println(answer);
    }
}