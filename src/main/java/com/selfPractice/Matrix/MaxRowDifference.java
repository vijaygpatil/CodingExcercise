package com.selfPractice.Matrix;

public class MaxRowDifference {
	// C++ program to find maximum difference of sum of
	// elements of two rows

	// Function to find maximum difference of sum of
	// elements of two rows such that second row appears
	// before first row.
	static int maxRowDiff(int mat[][], int m, int n) {
		// auxiliary array to store sum of all elements
		// of each row
		int rowSum[] = new int[m];

		// calculate sum of each row and store it in
		// rowSum array
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++)
				sum += mat[i][j];
			rowSum[i] = sum;
		}

		// calculating maximum difference of two elements
		// such that rowSum[i]<rowsum[j]
		int max_diff = rowSum[1] - rowSum[0];
		int min_element = rowSum[0];
		for (int i = 1; i < m; i++) {
			// if current difference is greater than
			// previous then update it
			if (rowSum[i] - min_element > max_diff)
				max_diff = rowSum[i] - min_element;

			// if new element is less than previous minimum
			// element then update it so that
			// we may get maximum difference in remaining array
			if (rowSum[i] < min_element)
				min_element = rowSum[i];
		}

		return max_diff;
	}

	// Driver program to run the case
	public static void main(String[] args) {
		int m = 5, n = 4;
		int mat[][] = { { -1, 2, 3, 4 }, { 5, 3, -2, 1 }, { 6, 7, 2, -3 }, { 2, 9, 1, 4 }, { 2, 1, -2, 0 } };

		System.out.println(maxRowDiff(mat, m, n));
	}

}
