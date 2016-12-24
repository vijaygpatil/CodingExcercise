package com.selfPractice.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class CheckIfNodesAreOnSamePath {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];
	
	int[] intime;
	int[] outtime;

	// Constructor
	CheckIfNodesAreOnSamePath(int v)
	{
		V = v;
		intime = new int[v];
		outtime = new int[v];
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	//Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v's list.
	}

	// A function used by DFS
	void DFSUtil(int v,boolean visited[], int[] intime, int[]outtime, int timer)
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v+" ");
		++timer;
		intime[v] = timer;
		
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited, intime, outtime, timer);
		}
		
		++timer;
		outtime[v] = timer;
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v)
	{
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		int timer = 0;
		
		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited, intime, outtime, timer);
		
		System.out.println(query(1, 5, intime, outtime)); 
		System.out.println(query(2, 9, intime, outtime));
		System.out.println(query(2, 6, intime, outtime));
	}
	
	// Returns true if 'u' and 'v' lie on same root to leaf path
	// else false.
	boolean query(int u, int v, int[] intime, int[] outtime)
	{
	    return ( (intime[u]<intime[v] && outtime[u]>outtime[v]) ||
	             (intime[v]<intime[u] && outtime[v]>outtime[u]) );
	}

	public static void main(String args[])
	{
		CheckIfNodesAreOnSamePath g = new CheckIfNodesAreOnSamePath(10);

		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 6);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(5, 7);
		g.addEdge(5, 8);
		g.addEdge(5, 9);

		System.out.println("Following is Depth First Traversal (starting from vertex 1)");

		g.DFS(1);
	}
}
