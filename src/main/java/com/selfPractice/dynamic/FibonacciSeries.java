package com.selfPractice.dynamic;

/**
 * Tiling 2X1 Tiles into 2XN Board
 * @author patil
 */

public class FibonacciSeries {
	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	static int fibDynamic(int n) {
		/* Declare an array to store Fibonacci numbers. */
		int f[] = new int[n + 1];
		int i;

		/* 0th and 1st number of the series are 0 and 1 */
		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= n; i++) {
			/*
			 * Add the previous 2 numbers in the series and store it
			 */
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}

	// Fibonacci Series using Space Optimized Method
	static int fibSpaceOptimized(int n) {
		int a = 0, b = 1, c, i;
		if (n == 0)
			return a;
		for (i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	/***********************************************/

	static int fibMatrixMultiplication(int n) {
		int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power(F, n - 1);

		return F[0][0];
	}

	/*
	 * Helper function that multiplies 2 matrices F and M of size 2*2, and puts
	 * the multiplication result back to F[][]
	 */
	static void multiply(int F[][], int M[][]) {
		int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
		int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
		int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
		int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}

	/*
	 * Helper function that calculates F[][] raise to the power n and puts the
	 * result in F[][] Note that this function is designed only for fib() and
	 * won't work as general power function
	 */
	static void power(int F[][], int n) {
		int i;
		int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };

		// n - 1 times multiply the matrix to {{1,0},{0,1}}
		for (i = 2; i <= n; i++)
			multiply(F, M);
	}

	/**********************************************/

	/* function that returns nth Fibonacci number */
	static int fibMatrixMultiplication2(int n) {
		int F[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		if (n == 0)
			return 0;
		power2(F, n - 1);

		return F[0][0];
	}

	/* Optimized version of power() in method 4 */
	static void power2(int F[][], int n) {
		if (n == 0 || n == 1)
			return;
		int M[][] = new int[][] { { 1, 1 }, { 1, 0 } };

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

	/* This code is contributed by Rajat Mishra */

	/**********************************************/

	public static void main(String args[]) {
		int n = 9;
		System.out.println(fib(n));
	}

}
