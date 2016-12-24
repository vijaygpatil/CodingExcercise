package com.selfPractice.Matrix;

public class RotateRingMatrixByKElements {
	// C++ program to rotate individual rings by k in
	// spiral order traversal.

	// Fills temp array into mat[][] using spiral order
	// traveral.
	static void fillSpiral(int mat[][], int m, int n, int temp[]) {
		int i = 0;
		int k = 0;
		int l = 0;

		/*
		 * k - starting row index m - ending row index l - starting column index
		 * n - ending column index
		 */
		int tIdx = 0; // Index in temp array
		while (k < m && l < n) {
			/* first row from the remaining rows */
			for (i = l; i < n; ++i)
				mat[k][i] = temp[tIdx++];
			k++;

			/* last column from the remaining columns */
			for (i = k; i < m; ++i)
				mat[i][n - 1] = temp[tIdx++];
			n--;

			/* last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i)
					mat[m - 1][i] = temp[tIdx++];
				m--;
			}

			/* first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i)
					mat[i][l] = temp[tIdx++];
				l++;
			}
		}
	}

	// Function to spirally traverse matrix and
	// rotate each ring of matrix by K elements
	// mat[][] --> matrix of elements
	// M --> number of rows
	// N --> number of columns
	static void spiralRotate(int mat[][], int M, int N, int k) {
		// Create a temporary array to store the result
		int temp[] = new int[M * N];

		/*
		 * s - starting row index m - ending row index l - starting column index
		 * n - ending column index;
		 */
		int m = M, n = N, s = 0, l = 0;

		int start = temp[0]; // Start position of current ring
		int tIdx = 0; // Index in temp
		while (s < m && l < n) {
			// Initialize end position of current ring
			int end = start;

			// copy the first row from the remaining rows
			for (int i = l; i < n; ++i) {
				temp[tIdx++] = mat[s][i];
				end++;
			}
			s++;

			// copy the last column from the remaining columns
			for (int i = s; i < m; ++i) {
				temp[tIdx++] = mat[i][n - 1];
				end++;
			}
			n--;

			// copy the last row from the remaining rows
			if (s < m) {
				for (int i = n - 1; i >= l; --i) {
					temp[tIdx++] = mat[m - 1][i];
					end++;
				}
				m--;
			}

			/* copy the first column from the remaining columns */
			if (l < n) {
				for (int i = m - 1; i >= s; --i) {
					temp[tIdx++] = mat[i][l];
					end++;
				}
				l++;
			}

			// if elements in current ring greater than
			// k then rotate elements of current ring
			if (end - start > k) {
				// Rotate current ring using reversal
				// algorithm for rotation
				reverse(temp, start, start + k);
				reverse(temp, start + k, end);
				reverse(temp, start, end);

				// Reset start for next ring
				start = end;
			} else // There are less than k elements in ring
				break;
		}

		// Fill temp array in original matrix.
		fillSpiral(mat, M, N, temp);
	}

	static void reverse(int arr[], int start, int end) {
		int temp;
		if (start >= end)
			return;
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverse(arr, start + 1, end - 1);
	}

	// Driver program to run the case
	public static void main(String[] args) {
		// Your C++ Code
		int M = 4, N = 4, k = 3;
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		spiralRotate(mat, M, N, k);

		// print modified matrix
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.println(mat[i][j] + " ");
			System.out.println();
		}
	}

}
