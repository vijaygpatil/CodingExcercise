package com.selfPractice.dynamic;

/**
 * Given a matrix where every cell represents points. How to collect maximum
 * points using two traversals under following conditions?
 * 
 * Let the dimensions of given grid be R x C.
 * 
 * 1) The first traversal starts from top left corner, i.e., (0, 0) and should
 * reach left bottom corner, i.e., (R-1, 0). The second traversal starts from
 * top right corner, i.e., (0, C-1) and should reach bottom right corner, i.e.,
 * (R-1, C-1)/
 * 
 * 2) From a point (i, j), we can move to (i+1, j+1) or (i+1, j-1) or (i+1, j)
 * 
 * 3) A traversal gets all points of a particular cell through which it passes.
 * If one traversal has already collected points of a cell, then the other
 * traversal gets no points if goes through that cell again.
 * 
 * Input : int arr[R][C] = {{3, 6, 8, 2}, {5, 2, 4, 3}, {1, 1, 20, 10}, {1, 1,
 * 20, 10}, {1, 1, 20, 10}, };
 * 
 * Output: 73
 * 
 * Explanation : running grid First traversal collects total points of value 3 +
 * 2 + 20 + 1 + 1 = 27
 * 
 * Second traversal collects total points of value 2 + 4 + 10 + 20 + 10 = 46.
 * Total Points collected = 27 + 46 = 73.
 * 
 * The idea is to do both traversals concurrently. We start first from (0, 0)
 * and second traversal from (0, C-1) simultaneously. The important thing to
 * note is, at any particular step both traversals will be in same row as in all
 * possible three moves, row number is increased. Let (x1, y1) and (x2, y2)
 * denote current positions of first and second traversals respectively. Thus at
 * any time x1 will be equal to x2 as both of them move forward but variation is
 * possible along y. Since variation in y could occur in 3 ways no change (y),
 * go left (y – 1), go right (y + 1). So in total 9 combinations among y1, y2
 * are possible. The 9 cases as mentioned below after base cases.
 * 
 * Both traversals always move forward along x Base Cases: 
 * If destinations reached if (x == R-1 && y1 == 0 && y2 == C-1) maxPoints(arr, x, y1, y2) = arr[x][y1] + arr[x][y2];
 * 
 * If any of the two locations is invalid (going out of grid) if input is not valid maxPoints(arr, x, y1, y2) = -INF (minus infinite)
 * 
 * If both traversals are at same cell, then we count the value of cell only once. If y1 and y2 are same result = arr[x][y1] Else result = arr[x][y1] + arr[x][y2]
 * 
 * Max of 9 cases 
 * result += max{  maxPoints(arr, x+1, y1+1, y2),
 * 				   maxPoints(arr, x+1, y1+1, y2+1), 
 *  			   maxPoints(arr, x+1, y1+1, y2-1),
 *                 maxPoints(arr, x+1, y1-1, y2), 
 * 				   maxPoints(arr, x+1, y1-1, y2+1),
 * 				   maxPoints(arr, x+1, y1-1, y2-1), 
 *  			   maxPoints(arr, x+1, y1, y2), 
 * 				   maxPoints(arr, x+1, y1, y2+1), 
 * 				   maxPoints(arr, x+1, y1, y2-1) 
 *				}
 */
public class CollectMaximumPointGridTwoTraversal {
	// A Memoization based program to find maximum collection
	// using two traversals of a grid
	private static final int R = 5;
	private static final int C = 4;

	// checks whether a given input is valid or not
	static boolean isValid(int x, int y1, int y2) {
		return (x >= 0 && x < R && y1 >= 0 && y1 < C && y2 >= 0 && y2 < C);
	}

	// Driver function to collect max value
	static int getMaxUtil(int[][] arr, int[][][] mem, int x, int y1, int y2) {
		/*---------- BASE CASES -----------*/
		// if P1 or P2 is at an invalid cell
		if (!isValid(x, y1, y2))
			return Integer.MIN_VALUE;

		// if both traversals reach their destinations
		if (x == R - 1 && y1 == 0 && y2 == C - 1)
			return arr[x][y1] + arr[x][y2];

		// If both traversals are at last row but not at their destination
		if (x == R - 1)
			return Integer.MIN_VALUE;

		// If subproblem is already solved
		if (mem[x][y1][y2] != -1)
			return mem[x][y1][y2];

		// Initialize answer for this subproblem
		int ans = Integer.MIN_VALUE;

		// this variable is used to store gain of current cell(s)
		int temp = (y1 == y2) ? arr[x][y1] : arr[x][y1] + arr[x][y2];

		/*
		 * Recur for all possible cases, then store and return the one with max
		 * value
		 */
		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1, y2 + 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1, y2));

		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 - 1, y2));
		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 - 1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 - 1, y2 + 1));

		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 + 1, y2));
		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 + 1, y2 - 1));
		ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 + 1, y2 + 1));

		

		return (mem[x][y1][y2] = ans);
	}

	// This is mainly a wrapper over recursive function getMaxUtil().
	// This function creates a table for memoization and calls
	// getMaxUtil()
	static int geMaxCollection(int[][] arr) {
		// Create a memoization table and initialize all entries as -1
		int[][][] mem = new int[R][C][C];
		// Arrays.fill(mem, -1);
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				for (int k = 0; k < C; k++)
					mem[i][j][k] = -1;

		// Calculation maximum value using memoization based function
		// getMaxUtil()
		return getMaxUtil(arr, mem, 0, 0, C - 1);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int[][] arr = { { 3, 6, 8, 2 }, { 5, 2, 4, 3 }, { 1, 1, 20, 10 }, { 1, 1, 20, 10 }, { 1, 1, 20, 10 }, };
		System.out.println("Maximum collection is " + geMaxCollection(arr));
	}

}
