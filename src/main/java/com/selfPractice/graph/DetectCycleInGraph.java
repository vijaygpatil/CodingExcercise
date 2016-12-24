package com.selfPractice.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleInGraph {

	private static int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private static LinkedList<Integer> adj[];

	// Constructor
	DetectCycleInGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}

	// This function is a variation of DFSUytil() in
	// http://www.geeksforgeeks.org/archives/18212
	static boolean isCyclicUtil(int v, boolean visited[], boolean[] recStack) {
		if (visited[v] == false) {
			// Mark the current node as visited and part of recursion stack
			visited[v] = true;
			recStack[v] = true;

			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n] && isCyclicUtil(n, visited, recStack))
					return true;
				else if (recStack[n])
					return true;
			}
		}
		recStack[v] = false; // remove the vertex from recursion stack
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	// This function is a variation of DFS() in
	// http://www.geeksforgeeks.org/archives/18212
	boolean isCyclic() {
		// Mark all the vertices as not visited and not part of recursion
		// stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		for (int i = 0; i < V; i++) {
			visited[i] = false;
			recStack[i] = false;
		}

		// Call the recursive helper function to detect cycle in different
		// DFS trees
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}

	public static void main(String args[]) {
		DetectCycleInGraph g = new DetectCycleInGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		if (g.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}

}
