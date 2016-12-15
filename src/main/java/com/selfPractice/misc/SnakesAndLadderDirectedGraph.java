package com.selfPractice.misc;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadderDirectedGraph {
	// C++ program to find minimum number of dice throws required to
	// reach last cell from first cell of a given snake and ladder
	// board m

	// This function returns minimum number of dice throws required to
	// Reach last cell from 0'th cell in a snake and ladder game.
	// move[] is an array of size N where N is no. of cells on board
	// If there is no snake or ladder from cell i, then move[i] is -1
	// Otherwise move[i] contains cell to which snake or ladder at i
	// takes to.
	static int getMinDiceThrows(int move[], int N) {
		// The graph has N vertices. Mark all the vertices as
		// not visited
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++)
			visited[i] = false;

		// Create a queue for BFS
		Queue<queueEntry> q = new LinkedList<>();

		// Mark the node 0 as visited and enqueue it.
		visited[0] = true;
		queueEntry s = new queueEntry(0, 0); // distance of 0't vertex is also 0
		q.add(s); // Enqueue 0'th vertex

		// Do a BFS starting from vertex at index 0
		queueEntry qe = null; // A queue entry (qe)
		while (!q.isEmpty()) {
			qe = q.peek();
			int v = qe.v; // vertex no. of queue entry

			// If front vertex is the destination vertex,
			// we are done
			if (v == N - 1)
				break;

			// Otherwise dequeue the front vertex and enqueue
			// its adjacent vertices (or cell numbers reachable
			// through a dice throw)
			q.poll();
			for (int j = v + 1; j <= (v + 6) && j < N; ++j) {
				// If this cell is already visited, then ignore
				if (!visited[j]) {
					// Otherwise calculate its distance and mark it
					// as visited
					queueEntry a = new queueEntry(0, 0);
					a.dist = (qe.dist + 1);
					visited[j] = true;

					// Check if there a snake or ladder at 'j'
					// then tail of snake or top of ladder
					// become the adjacent of 'i'
					if (move[j] != -1)
						a.v = move[j];
					else
						a.v = j;
					q.add(a);
				}
			}
		}

		// We reach here when 'qe' has last vertex
		// return the distance of vertex in 'qe'
		return qe.dist;
	}

	// Driver program to test methods of graph class
	public static void main(String[] args) {
		// Let us construct the board given in above diagram
		int N = 30;
		int[] moves = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
	}

}

// An entry in queue used in BFS
class queueEntry {
	int v; // Vertex Number
	int dist; // Distance of Vertex from source

	public queueEntry(int v, int dist) {
		super();
		this.v = v;
		this.dist = dist;
	}
}
