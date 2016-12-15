package com.selfPractice.dynamic;

class CostOfMakingStringIdentical {
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

		return costx * (m - lcs) + costy * (n - lcs);
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
