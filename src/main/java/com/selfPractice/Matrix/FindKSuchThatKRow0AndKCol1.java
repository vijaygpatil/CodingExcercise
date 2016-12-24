package com.selfPractice.Matrix;

/*
 * 1) Start from top right corner, i.e., i = 0, j = n-1. Initialize result as
 * -1.
 * 
 * 2) Do following until we find the result or reach outside the matrix.
 * 
 * ......a) If mat[i][j] is 0, then check all elements on left of j in current
 * row. .........If all elements on left of j are also 0, then set result as i.
 * Note .........that i may not be result, but if there is a result, then it
 * must be i .........(Why? we reach mat[i][j] after discarding all rows above
 * it and all .........columns on right of it)
 * 
 * .........If all left side elements of i'th row are not 0, them this row
 * cannot .........be a solution, increment i.
 * 
 * ......b) If mat[i][j] is 1, then check all elements below i in current
 * column. .........If all elements below i are 1, then set result as j. Note
 * that j may ......... not be result, but if there is a result, then it must be
 * j
 * 
 * .........If all elements of j'th column are not 1, them this column cannot be
 * a .........solution decrement j.
 * 
 * 3) If result is -1, return it.
 * 
 * 4) Else check validity of result by checking all row and column elements of
 * result
 */
public class FindKSuchThatKRow0AndKCol1 {
	// C++ program to find i such that all entries in i'th row are 0
	// and all entries in i't column are 1
	private static final int n = 5;

	static int find(int arr[][]) {
		// Start from top-most rightmost corner
		// (We could start from other corners also)
		int i = 0, j = n - 1;

		// Initialize result
		int res = -1;

		// Find the index (This loop runs at most 2n times, we either
		// increment row number or decrement column number)
		while (i < n && j >= 0) {
			// If current element is 0, then this row may be a solution
			if (arr[i][j] == 0) {
				// Check for all elements in this row
				while (j >= 0 && (arr[i][j] == 0 || i == j))
					j--;

				// If all values are 0, then store this row as result
				if (j == -1) {
					res = i;
					break;
				}

				// We reach here if we found a 1 in current row, so this
				// row cannot be a solution, increment row number
				else
					i++;
			} else // If current element is 1
			{
				// Check for all elements in this column
				while (i < n && (arr[i][j] == 1 || i == j))
					i++;

				// If all elements are 1
				if (i == n) {
					res = j;
					break;
				}

				// We reach here if we found a 0 in current column, so this
				// column cannot be a solution, increment column number
				else
					j--;
			}
		}

		// If we could not find result in above loop, then result doesn't exist
		if (res == -1)
			return res;

		// Check if above computed res is valid
		for (i = 0; i < n; i++)
			if (res != i && arr[i][res] != 1)
				return -1;
		for (j = 0; j < n; j++)
			if (res != j && arr[res][j] != 0)
				return -1;

		return res;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 1, 1, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
		System.out.println(find(mat));
	}

}
