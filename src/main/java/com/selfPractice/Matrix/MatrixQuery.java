package com.selfPractice.Matrix;

public class MatrixQuery {
	// C++ implementation of program

	// Fills initial values in rows[] and cols[]
	static void preprocessMatrix(int rows[], int cols[], int m, int n)
	{
		// Fill rows with 1 to m-1
		for (int i=0; i<m; i++)
			rows[i] = i;

		// Fill columns with 1 to n-1
		for (int i=0; i<n; i++)
			cols[i] = i;
	}

	// Function to perform queries on matrix
	// m --> number of rows
	// n --> number of columns
	// ch --> type of query
	// x --> number of row for query
	// y --> number of column for query
	static void queryMatrix(int rows[], int cols[], int m, int n, char ch, int x, int y)
	{
		// perform queries
		int tmp;
		switch(ch)
		{
		case 'R':

			// swap row x with y
			swap(rows[x-1], rows[y-1]);
			break;

		case 'C':

			// swap coloumn x with y
			swap(cols[x-1], cols[y-1]);
			break;

		case 'P':

			// Print value at (x, y)
			System.out.println((rows[x-1]*n + cols[y-1]+1));
			break;
		}
		return ;
	}
	
	private static void swap(int a, int b) {
		// swapping value of two numbers without using temp variable and XOR
		// bitwise operator
		a = a ^ b; // now a is 6 and b is 4
		b = a ^ b; // now a is 6 but b is 2 (original value of a)
		a = a ^ b; // now a is 4 and b is 2, numbers are swapped
	}

	// Driver program to run the case
	public static void main(String[] args)
	{
		int m = 1234, n = 5678;

		// row[] is array for rows and cols[]
		// is array for coloumns
		int[] rows = new int[m];
		int[] cols = new int[n];

		// Fill initial values in rows[] and cols[]
		preprocessMatrix(rows, cols, m, n);

		queryMatrix(rows, cols, m, n, 'R', 1, 2);
		queryMatrix(rows, cols, m, n, 'P', 1, 1);
		queryMatrix(rows, cols, m, n, 'P', 2, 1);
		queryMatrix(rows, cols, m, n, 'C', 1, 2);
		queryMatrix(rows, cols, m, n, 'P', 1, 1);
		queryMatrix(rows, cols, m, n, 'P', 2, 1);
	}

}
