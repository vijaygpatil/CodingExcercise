package com.selfPractice.misc;

public class MaxiumSizeSubMatrixWithAll1 {
	public static void printMaxSubSquare(Integer M[][]) {
		int i, j;
		Integer S[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		int max_of_s, max_i, max_j;

		int R = M.length;
		int C = M[0].length;

		for (i = 0; i < R; i++)
			S[i][0] = M[i][0];

		for (j = 0; j < C; j++)
			S[0][j] = M[0][j];

		for (i = 1; i < R; i++) {
			for (j = 1; j < C; j++) {
				if (M[i][j] == 1)
					S[i][j] = Math.min(S[i][j - 1], Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
				else
					S[i][j] = 0;
			}
		}

		max_of_s = S[0][0];
		max_i = 0;
		max_j = 0;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (max_of_s < S[i][j]) {
					max_of_s = S[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}

		System.out.println("Maximum size sub-matrix is:");
		for (i = max_i; i > max_i - max_of_s; i--) {
			for (j = max_j; j > max_j - max_of_s; j--) {
				System.out.printf("%d ", M[i][j]);
			}
			System.out.print("\n");
		}
	}

	int min(int a, int b, int c) {
		int m = a;
		if (m > b)
			m = b;
		if (m > c)
			m = c;
		return m;
	}

	public static void main(String[] args) {

		Integer M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		printMaxSubSquare(M);
	}
}
