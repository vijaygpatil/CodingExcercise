package com.selfPractice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class TwoCliqueProblem {
	// C++ program to find out whether a given graph can be
	// converted to two Cliques or not.
	private static final int V = 5;

	// This function returns true if subgraph reachable from
	// src is Bipartite or not.
	static boolean isBipartiteUtil(int G[][], int src, int colorArr[]) {
		colorArr[src] = 1;

		// Create a queue (FIFO) of vertex numbers and enqueue
		// source vertex for BFS traversal
		Queue<Integer> q = new LinkedList<>();
		q.add(src);

		// Run while there are vertices in queue (Similar to BFS)
		while (!q.isEmpty()) {
			// Dequeue a vertex from queue
			int u = q.poll();

			// Find all non-colored adjacent vertices
			for (int v = 0; v < V; ++v) {
				// An edge from u to v exists and destination
				// v is not colored
				if (G[u][v] == 1 && colorArr[v] == -1) {
					// Assign alternate color to this adjacent
					// v of u
					colorArr[v] = 1 - colorArr[u];
					q.add(v);
				}

				// An edge from u to v exists and destination
				// v is colored with same color as u
				else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
					return false;
			}
		}

		// If we reach here, then all adjacent vertices can
		// be colored with alternate color
		return true;
	}

	// Returns true if a Graph G[][] is Bipartite or not. Note
	// that G may not be connected.
	static boolean isBipartite(int G[][]) {
		// Create a color array to store colors assigned
		// to all veritces. Vertex number is used as index in
		// this array. The value '-1' of colorArr[i]
		// is used to indicate that no color is assigned to
		// vertex 'i'. The value 1 is used to indicate first
		// color is assigned and value 0 indicates
		// second color is assigned.
		int colorArr[] = new int[V];
		for (int i = 0; i < V; ++i)
			colorArr[i] = -1;

		// One by one check all not yet colored vertices.
		for (int i = 0; i < V; i++)
			if (colorArr[i] == -1)
				if (isBipartiteUtil(G, i, colorArr) == false)
					return false;

		return true;
	}

	// Returns true if G can be divided into
	// two Cliques, else false.
	static boolean canBeDividedinTwoCliques(int G[][]) {
		// Find complement of G[][]
		// All values are complemented except
		// diagonal ones

		int[][] GC = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i != j) {
					if (G[i][j] == 1)
						GC[i][j] = 0;
					else
						GC[i][j] = 1;
				} else {
					GC[i][j] = 0;
				}
			}
		}

		// Return true if complement is Bipartite
		// else false.
		return isBipartite(GC);
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int G[][] = { { 0, 1, 1, 1, 0 }, { 1, 0, 1, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 0 } };

		if (canBeDividedinTwoCliques(G))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
