package com.selfPractice.Matrix;

public class MagicSquare {

	// A function to generate odd sized magic squares
	static void generateSquare(int n) {
		int magicSquare[][] = new int[n][n];

		// set all slots as 0
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magicSquare[i][j] = 0;
			}
		}

		// Initialize position for 1
		int i = n / 2;
		int j = n - 1;

		// One by one put all values in magic square
		for (int num = 1; num <= n * n;) {
			if (i == -1 && j == n) // 3rd condition
			{
				j = n - 2;
				i = 0;
			} else {
				// 1st condition helper if next number goes to out of square's
				// right side
				if (j == n)
					j = 0;
				// 1st condition helper if next number is goes to out of
				// square's upper side
				if (i < 0)
					i = n - 1;
			}

			if (magicSquare[i][j] != 0) // 2nd condition
			{
				j -= 2;
				i++;
				continue;
			} else
				magicSquare[i][j] = num++; // set number

			j++;
			i--; // 1st condition
		}

		// print magic square
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(magicSquare[i][j] + " ");
			System.out.println();
		}
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int n = 8; // Works only when n is odd
		generateSquare(n);
	}

}
