package com.selfPractice.Matrix;

public class NumberOfPathWithExactlyKCoins {
	private static final int R = 3;
	private static final int C = 3;
	private static final int MAX_K = 1000;

	public static void main(String[] args) {
		int k = 12;
		int mat[][] = { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };
		System.out.println("Number of Counts: " + pathCount(mat, k));
	}

	static int pathCount(int mat[][], int k) {
		return pathCountDP(mat, R - 1, C - 1, k);
	}

	static int pathCountRec(int[][] mat, int m, int n, int k) {
		if (m < 0 || n < 0)
			return 0;

		if (m == 0 && n == 0 && k == mat[m][n])
			return 1;

		return pathCountRec(mat, m - 1, n, k - mat[m][n]) + pathCountRec(mat, m, n - 1, k - mat[m][n]);
	}

	static int pathCountDP(int mat[][], int m, int n, int k) {

		int[][][] dp = new int[m][n][k];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				for (int l = 0; l < MAX_K; l++)
					dp[i][j][MAX_K] = -1;

		if (m < 0 || n < 0)
			return 0;

		if (m == 0 && n == 0 && k == mat[m][n])
			return 0;

		if (dp[m][n][k] != -1)
			return dp[m][n][k];

		dp[m][n][k] = pathCountRec(mat, m - 1, n, k - mat[m][n]) + pathCountRec(mat, m, n - 1, k - mat[m][n]);

		return dp[m][n][k];
	}
}
