package com.selfPractice.Matrix;

public class LatinSquare {
	// C++ program to pritn Latin Square
	// Function to print n x n Latin Square
	static void printLatin(int n)
	{
		// A variable to control the rotation
		// point.
		int k = n+1;

		// Loop to print rows
		for (int i=1; i<=n; i++)
		{
			// This loops runs only after first
			// iteration of outer loop. It prints
			// numbers from n to k
			int temp = k;
			while (temp <= n)
			{
				System.out.print(temp+" ");
				temp++;
			}

			// This loop prints numbers from 1 to k-1.
			for (int j=1; j<k; j++)
				System.out.print(j+" ");

			k--;
			System.out.println();
		}
	}

	// Driver program to test above function
	public static void main(String[] args)
	{
		int n = 5;

		// Invoking printLatin function
		printLatin(5);

	}

}
