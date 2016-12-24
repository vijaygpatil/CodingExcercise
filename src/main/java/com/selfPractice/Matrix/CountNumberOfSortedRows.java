package com.selfPractice.Matrix;

public class CountNumberOfSortedRows {
	// C++ program to find number of sorted rows
	// Function to count all sorted rows in a matrix
	static int sortedCount(int mat[][], int r, int c)
	{
		int result = 0; // Initialize result

		// Start from left side of matrix to
		// count increasing order rows
		for (int i=0; i<r; i++)
		{
			// Check if there is any pair ofs element
			// that are not in increasing order.
			int j;
			for (j=0; j<c-1; j++)
				if (mat[i][j+1] <= mat[i][j])
					break;

			// If the loop didn't break (All elements
			// of current row were in increasing order)
			if (j == c-1)
				result++;
		}

		// Start from right side of matrix to
		// count increasing order rows ( refrence
		// to left these are in decreasing order )
		for (int i=0; i<r; i++)
		{
			// Check if there is any pair ofs element
			// that are not in decreasing order.
			int j;
			for (j=c-1; j>0; j--)
				if (mat[i][j-1] <= mat[i][j])
					break;

			// Note c > 1 condition is required to make
			// sure that a single column row is not counted
			// twice (Note that a single column row is sorted
			// both in increasing and decreasing order) 
			if (c > 1 && j == 0)
				result++;
		}
		return result;
	}

	// Driver program to run the case
	public static void main(String[] args)
	{
		int m = 4, n = 5;
		int mat[][] = {{1, 2, 3, 4, 5},
						{4, 3, 1, 2, 6},
						{8, 7, 6, 5, 4},
						{5, 7, 8, 9, 10}};
		System.out.println(sortedCount(mat, m, n));
	}

}
