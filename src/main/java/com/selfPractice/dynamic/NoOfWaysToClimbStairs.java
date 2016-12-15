package com.selfPractice.dynamic;

public class NoOfWaysToClimbStairs {

	/***********************************************************/
	// A simple recursive program to find n'th fibonacci number
	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	// Returns number of ways to reach s'th stair
	static int countWays(int s) {
		return fib(s + 1);
	}

	/***********************************************************/

	/***********************************************************/
	// A recursive function used by countWays
	static int countWaysUtil(int n, int m) {
		if (n <= 1)
			return n;
		int res = 0;
		for (int i = 1; i <= m && i <= n; i++)
			res += countWaysUtil(n - i, m);
		return res;
	}

	// Returns number of ways to reach s'th stair
	static int countWays(int s, int m) {
		return countWaysUtil(s + 1, m);
	}

	/***********************************************************/

	/***********************************************************/
	// A recursive function used by countWays
	static int countWaysUtilDP(int n, int m) {
		int[] res = new int[n];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n; i++) {
			res[i] = 0;
			for (int j = 1; j <= m && j <= i; j++)
				res[i] += res[i - j];
		}
		return res[n - 1];
	}

	// Returns number of ways to reach s'th stair
	static int countWaysDP(int s, int m) {
		return countWaysUtilDP(s + 1, m);
	}

	/***********************************************************/

	/* Driver program to test above function */
	public static void main(String args[]) {
		int s = 4;
		System.out.println("Number of ways = " + countWays(s));
	}
}
