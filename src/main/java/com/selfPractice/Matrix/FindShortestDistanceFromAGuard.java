package com.selfPractice.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestDistanceFromAGuard {
	// C++ program to replace all of the O's in the matrix
	// with their shortest distance from a guard
	// store dimensions of the matrix
	private static final int M = 5;
	private static final int N = 5;

	// An Data Structure for queue used in BFS
	class queueNode {
		// i, j and distance stores x and y-coordinates
		// of a matrix cell and its distance from guard
		// respectively
		int i, j, distance;
	};

	// These arrays are used to get row and column
	// numbers of 4 neighbors of a given cell
	static int row[] = { -1, 0, 1, 0 };
	static int col[] = { 0, 1, 0, -1 };

	// return true if row number and column number
	// is in range
	static boolean isValid(int i, int j) {
		if ((i < 0 || i > M - 1) || (j < 0 || j > N - 1))
			return false;

		return true;
	}

	// return true if current cell is an open area and its
	// distance from guard is not calculated yet
	static boolean isSafe(int i, int j, char matrix[][], int output[][]) {
		if (matrix[i][j] != 'O' || output[i][j] != -1)
			return false;

		return true;
	}

	// Function to replace all of the O's in the matrix
	// with their shortest distance from a guard
	static void findDistance(char matrix[][]) {
		int[][] output = new int[M][N];
		Queue<QueueNode> q = new LinkedList<>();

		// finding Guards location and adding into queue
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// initialize each cell as -1
				output[i][j] = -1;
				if (matrix[i][j] == 'G') {
					QueueNode pos = new QueueNode(i, j, 0);
					q.add(pos);
					// guard has 0 distance
					output[i][j] = 0;
				}
			}
		}

		// do till queue is empty
		while (!q.isEmpty()) {
			// get the front cell in the queue and update
			// its adjacent cells
			QueueNode curr = q.poll();

			int x = curr.i;
			int y = curr.j;
			int dist = curr.distance;

			// do for each adjacent cell
			for (int i = 0; i < 4; i++) {
				// if adjacent cell is valid, has path and
				// not visited yet, en-queue it.
				if (isSafe(x + row[i], y + col[i], matrix, output) && isValid(x + row[i], y + col[i])) {
					output[x + row[i]][y + col[i]] = dist + 1;

					QueueNode pos = new QueueNode(x + row[i], y + col[i], dist + 1);
					q.add(pos);
				}
			}
		}

		// print output matrix
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.println(output[i][j] + " ");
			System.out.println();
		}
	}

	// Driver code
	public static void main(String[] args) {
		char matrix[][] = { { 'O', 'O', 'O', 'O', 'G' }, { 'O', 'W', 'W', 'O', 'O' }, { 'O', 'O', 'O', 'W', 'O' }, { 'G', 'W', 'W', 'W', 'O' }, { 'O', 'O', 'O', 'O', 'G' } };

		findDistance(matrix);
	}

}

// An Data Structure for queue used in BFS
class QueueNode {
	// i, j and distance stores x and y-coordinates
	// of a matrix cell and its distance from guard
	// respectively
	int i, j, distance;

	public QueueNode(int i, int j, int distance) {
		super();
		this.i = i;
		this.j = j;
		this.distance = distance;
	}
};
