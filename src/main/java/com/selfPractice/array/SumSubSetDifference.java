package com.selfPractice.array;

/**
 * Sum = SumL - SumF 
 * SumF = a1.2^n-1 + a2.2^n-2 .... an.2^0; 
 * SumL = a1.2^0 + a1.2^1 + a2.2^2 ... an.2^n-1
 */
public class SumSubSetDifference {
	public static void main(String[] arg) {
		int n = 4;
		int S[] = { 5, 2, 9, 6 };
		System.out.println(sumSubSetDiff(S, n));
	}

	// Returns the sum of first elements of all subsets
	static double SumF(int S[], int n) {
		double sum = 0;

		// Compute the SumF as given in the above explanation
		for (int i = 0; i < n; i++)
			sum = sum + (S[i] * Math.pow(2, n - i - 1));
		return sum;
	}

	// Returns the sum of last elements of all subsets
	static double SumL(int S[], int n) {
		double sum = 0;

		// Compute the SumL as given in the above explanation
		for (int i = 0; i < n; i++)
			sum = sum + (S[i] * Math.pow(2, i));
		return sum;
	}

	// Returns the difference between sum of last elements of
	// each subset and the sum of first elements of each subset
	static double sumSubSetDiff(int S[], int n) {
		return SumL(S, n) - SumF(S, n);
	}
}
