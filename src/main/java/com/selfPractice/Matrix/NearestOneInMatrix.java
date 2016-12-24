package com.selfPractice.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NearestOneInMatrix {
	// C++ program to find the minimum distance from a
	// "1" in bianry matrix.
	// distance matrix which stores the distnace of
	// nearest '1'
	// Function to find the nearest '1'
	static void nearestOne(int mat[][], int m, int n, int dist[][]) {
		// two array when respective values of newx and
		// newy are added to (i,j) it gives up, down,
		// left or right adjacent of (i,j) cell
		int newx[] = { -1, 0, 1, 0 };
		int newy[] = { 0, -1, 0, 1 };

		// queue of pairs to store nodes for bfs
		Queue<Pair> q = new LinkedList<>();

		// traverse matrix and make pair of indices of
		// cell (i,j) having value '1' and push them
		// in queue
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = Integer.MAX_VALUE;

				if (mat[i][j] == 1) {
					// distace of '1' from itself is always 0
					dist[i][j] = 0;

					// make pair and push it in queue
					q.add(new Pair(i, j));
				}
			}
		}

		// now do bfs traversal
		// pop element from queue one by one untill it gets empty
		// pair element to hold the currently poped element
		Pair poped;
		while (!q.isEmpty()) {
			poped = q.poll();

			// coordinate of currently poped node
			int x = poped.m;
			int y = poped.n;

			// now check for all adjancent of poped element
			for (int i = 0; i < 4; i++) {
				int adjx = x + newx[i];
				int adjy = y + newy[i];

				// if new coordinates are within boundry and
				// we can minimize the distance of adjancent
				// then update the distnace of adjacent in
				// distance matrix and push this adjacent
				// element in queue for further bfs
				if (adjx >= 0 && adjx < m && adjy >= 0 && adjy < n && dist[adjx][adjy] > dist[x][y] + 1) {
					// update distance
					dist[adjx][adjy] = dist[x][y] + 1;
					q.add(new Pair(adjx, adjy));
				}
			}
		}
	}

	// Driver program to run the case
	public static void main(String[] args) {
		int m = 3, n = 4;
		int mat[][] = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };

		int[][] dist = new int[3][4];

		// Fills values in dist[][]
		nearestOne(mat, m, n, dist);

		// print distance matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.println(dist[i][j] + " ");
			System.out.println();
		}
	}
}

class Pair {
	int n;
	int m;

	public Pair(int n, int m) {
		this.n = n;
		this.m = m;
	}
}
