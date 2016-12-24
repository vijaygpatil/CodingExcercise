package com.selfPractice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DijkstraAlgorithmToFindMinumumCostPathInMatrix {
	// C++ program to get least cost path in a grid from
	// top-left to bottom-right
	private static final int ROW = 5;
	private static final int COL = 5;

	// Utility method for comparing two cells
	static boolean operator(cell a, cell b) {
		if (a.distance == b.distance) {
			if (a.x != b.x)
				return (a.x < b.x);
			else
				return (a.y < b.y);
		}
		return (a.distance < b.distance);
	}

	// Utility method to check whether a point is
	// inside the grid or not
	static boolean isInsideGrid(int i, int j) {
		return (i >= 0 && i < COL && j >= 0 && j < ROW);
	}

	// Method returns minimum cost to reach bottom
	// right from top left
	static int shortest(int grid[][], int row, int col) {
		int dis[][] = new int[row][col];

		// initializing distance array by INT_MAX
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				dis[i][j] = Integer.MAX_VALUE;

		// direction arrays for simplification of getting
		// neighbour
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		Queue<cell> st = new LinkedList<>();

		// insert (0, 0) cell with 0 distance
		st.add(new cell(0, 0, 0));

		// initialize distance of (0, 0) with its grid value
		dis[0][0] = grid[0][0];

		// loop for standard dijkstra's algorithm
		while (!st.isEmpty()) {
			// get the cell with minimum distance and delete
			// it from the set
			cell k = st.poll();

			// looping through all neighbours
			for (int i = 0; i < 4; i++) {
				int x = k.x + dx[i];
				int y = k.y + dy[i];

				// if not inside boundry, ignore them
				if (!isInsideGrid(x, y))
					continue;

				// If distance from current cell is smaller, then
				// update distance of neighbour cell
				if (dis[x][y] > dis[k.x][k.y] + grid[x][y]) {
					// If cell is already there in set, then
					// remove its previous entry
					// if (dis[x][y] != Integer.MAX_VALUE)
					// st.remove(st.find(cell(x, y, dis[x][y])));

					// update the distance and insert new updated
					// cell in set
					dis[x][y] = dis[k.x][k.y] + grid[x][y];
					st.add(new cell(x, y, dis[x][y]));
				}
			}
		}

		// uncomment below code to print distance
		// of each cell from (0, 0)
		/*
		 * for (int i = 0; i < row; i++, cout << endl) for (int j = 0; j < col;
		 * j++) cout << dis[i][j] << " ";
		 */
		// dis[row - 1][col - 1] will represent final
		// distance of bottom right cell from top left cell
		return dis[row - 1][col - 1];
	}

	// Driver code to test above methods
	public static void main(String[] args) {
		int grid[][] = { { 31, 100, 65, 12, 18 }, { 10, 13, 47, 157, 6 }, { 100, 113, 174, 11, 33 }, { 88, 124, 41, 20, 140 }, { 99, 32, 111, 41, 20 } };

		System.out.println(shortest(grid, ROW, COL));
	}

}

// structure for information of each cell
class cell {
	int x, y;
	int distance;

	cell(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
