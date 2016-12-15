package com.selfPractice.misc;

/**
 * Count the number of expressions containing n pairs of parentheses which are
 * correctly matched. For n = 3, possible expressions are ((())), ()(()),
 * ()()(), (())(), (()()).
 * 
 * 2) Count the number of possible Binary Search Trees with n keys (See this)
 * 
 * 3) Count the number of full binary trees (A rooted binary tree is full if
 * every vertex has either two children or no children) with n+1 leaves.
 *
 */
public class CatalanNumber {

	// A recursive function to find nth catalan number
	int catalan(int n) {
		int res = 0;

		// Base case
		if (n <= 1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			res += catalan(i) * catalan(n - i - 1);
		}
		return res;
	}

	// A dynamic programming based function to find nth
	// Catalan number
	int catalanDynamicProgrammingP(int n) {
		// Table to store results of subproblems
		int[] catalan = new int[n + 1];

		// Initialize first two values in table
		catalan[0] = catalan[1] = 1;

		// Fill entries in catalan[] using recursive formula
		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++)
				catalan[i] += catalan[j] * catalan[i - j - 1];
		}

		// Return last entry
		return catalan[n];
	}

	public static void main(String[] args) {
		CatalanNumber cn = new CatalanNumber();
		for (int i = 0; i < 10; i++) {
			System.out.print(cn.catalan(i) + " ");
		}
	}
}
