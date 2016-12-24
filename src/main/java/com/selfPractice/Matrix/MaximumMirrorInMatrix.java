package com.selfPractice.Matrix;

import java.util.Arrays;

public class MaximumMirrorInMatrix {
	// C++ program to find how many mirror can transfer
	// light from bottom to right

	// method returns number of mirror which can transfer
	// light from bottom to right
	static int maximumMirrorInMatrix(char[][] mat, int N) {
		// To store first obstacles horizontaly (from right)
		// and vertically (from bottom)
		int horizontal[] = new int[N];
		int vertical[] = new int[N];

		Arrays.fill(horizontal, 0);
		Arrays.fill(vertical, 0);

		// looping matrix to mark column for obstacles
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (mat[i][j] == 'B')
					continue;

				// mark rightmost column with obstacle
				horizontal[i] = j;
				break;
			}
		}

		// looping matrix to mark rows for obstacles
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (mat[i][j] == 'B')
					continue;

				// mark leftmost row with obstacle
				vertical[j] = i;
				break;
			}
		}

		int res = 0; // Initialize result

		// if there is not obstacle on right or below,
		// then mirror can be placed to transfer light
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				/*
				 * if i > vertical[j] then light can from bottom if j >
				 * horizontal[i] then light can go to right
				 */
				if (i > vertical[j] && j > horizontal[i]) {
					/*
					 * uncomment this code to print actual mirror position also
					 * cout << i << " " << j << endl;
					 */
					res++;
				}
			}
		}

		return res;
	}

	// Driver code to test above method
	public static void main(String[] args) {
		int N = 5;

		// B - Blank O - Obstacle
		char[][] mat = { { 'B', 'B', 'O', 'B', 'B' }, { 'B', 'B', 'B', 'B', 'O' }, { 'B', 'B', 'B', 'B', 'B' }, { 'B', 'O', 'O', 'B', 'O' }, { 'B', 'B', 'B', 'O', 'B' } };

		System.out.println(maximumMirrorInMatrix(mat, N));
	}

}
