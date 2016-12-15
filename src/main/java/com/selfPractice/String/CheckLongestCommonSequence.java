package com.selfPractice.String;

class CheckLongestCommonSequence {
	public static void main(String[] args) {
		char X[] = "abcd".toCharArray();
		char Y[] = "acdb".toCharArray();
		System.out.println("Minimum Cost to make two strings identical is = " + findMinCost(X, Y, 10, 20));

		char A[] = "sunday".toCharArray();
		char B[] = "saturday".toCharArray();
		System.out.println("Minimum Cost to make two strings identical is = " + findMinCost(A, B, 1, 1));

	}

	public static int findMinCost(char[] x, char[] y, int costx, int costy) {
		int m = x.length;
		int n = y.length;

		int lcs = findLCS(x, y, m, n);

		System.out.println(lcs);

		// return costx * (m - lcs) + costy * (n - lcs);
		return costy * (n - lcs);
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

	static int min(int x, int y, int z) {
		if (x < y && x < z)
			return x;
		if (y < x && y < z)
			return y;
		else
			return z;
	}

	static int editDist(String str1, String str2, int m, int n) {
		// If first string is empty, the only option is to
		// insert all characters of second string into first
		if (m == 0)
			return n;

		// If second string is empty, the only option is to
		// remove all characters of first string
		if (n == 0)
			return m;

		// If last characters of two strings are same, nothing
		// much to do. Ignore last characters and get count for
		// remaining strings.
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return editDist(str1, str2, m - 1, n - 1);

		// If last characters are not same, consider all three
		// operations on last character of first string, recursively
		// compute minimum cost for all three operations and take
		// minimum of three values.
		return 1 + min(editDist(str1, str2, m, n - 1), // Insert
				editDist(str1, str2, m - 1, n), // Remove
				editDist(str1, str2, m - 1, n - 1) // Replace
		);
	}

	static int editDistDP(String str1, String str2, int m, int n) {
		// Create a table to store results of subproblems
		int dp[][] = new int[m + 1][n + 1];

		// Fill d[][] in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// If first string is empty, only option is to
				// isnert all characters of second string
				if (i == 0)
					dp[i][j] = j; // Min. operations = j

				// If second string is empty, only option is to
				// remove all characters of second string
				else if (j == 0)
					dp[i][j] = i; // Min. operations = i

				// If last characters are same, ignore last char
				// and recur for remaining string
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];

				// If last character are different, consider all
				// possibilities and find minimum
				else
					dp[i][j] = 1 + min(dp[i][j - 1], // Insert
							dp[i - 1][j], // Remove
							dp[i - 1][j - 1]); // Replace
			}
		}

		return dp[m][n];
	}
}
