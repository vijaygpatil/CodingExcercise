package com.selfPractice.array;

public class PrintSubSequence {
	/*
	 * C++ code to generate all possible subsequences. Time Complexity O(n *
	 * 2^n)
	 */

	static void printSubsequences(int arr[], int n) {
		/* Number of subsequences is (2^n -1) */
		int opsize = (int) Math.pow(2, n);

		/* Run from counter 000..1 to 111..1 */
		for (int counter = 1; counter < opsize; counter++) {
			for (int j = 0; j < n; j++) {
				/*
				 * Check if jth bit in the counter is set If set then print jth
				 * element from arr[]
				 */
				if ((counter & (1<<j)) != 0)
					System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}

	// Driver program
	public static void main(String[] args) {
		int arr[] = { 4, 2, 7, 5 };
		int n = arr.length;
		printSubsequences(arr, n);
	}

}
