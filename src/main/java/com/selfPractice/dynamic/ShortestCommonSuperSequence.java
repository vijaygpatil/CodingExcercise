package com.selfPractice.dynamic;

class ShortestCommonSuperSequence {
	public static void main(String[] args) {
		char X[] = "AGGTAB".toCharArray();
		char Y[] = "GXTXAYB".toCharArray();
		System.out.println("ShortestCommonSuperSequence = " + findShortestCommonSequence(X, Y, X.length, Y.length));
	}

	// Function to find length of the shortest supersequence
	// of X and Y.
	static int findShortestCommonSequence(char X[], char Y[], int m, int n) {

		int l = findLCS(X, Y, m, n); // find lcs

		// Result is sum of input string lengths - length of lcs
		return (m + n - l);
	}

	public static int findLCS(char[] x, char[] y, int m, int n) {
		int[][] L = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(L[i][j] + " ");
			}
			System.out.println();
		}

		return L[m][n];
	}
}
