package com.selfPractice.array;

public class MinimumOperationsToGetToTargetArray {
	/*
	 * C++ program to count minimum number of operations to get the given target
	 * array
	 */

	// Returns count of minimum operations to covert a
	// zero array to target array with increment and
	// doubling operations.
	// This function computes count by doing reverse
	// steps, i.e., convert target to zero array.
	static int countMinOperations(int target[], int n) {
		// Initialize result (Count of minimum moves)
		int result = 0;

		// Keep looping while all elements of target
		// don't become 0.
		while (true) {
			// To store count of zeroes in current
			// target array
			int zero_count = 0;

			int i; // To find first odd element
			for (i = 0; i < n; i++) {
				// If odd number found
				if ((target[i] & 1) == 1)
					break;

				// If 0, then increment zero_count
				else if (target[i] == 0)
					zero_count++;
			}

			// All numbers are 0
			if (zero_count == n)
				return result;

			// All numbers are even
			if (i == n) {
				// Divide the whole array by 2
				// and increment result
				for (int j = 0; j < n; j++)
					target[j] = target[j] / 2;
				result++;
			}

			// Make all odd numbers even by subtracting
			// one and increment result.
			for (int j = i; j < n; j++) {
				if ((target[j] & 1) == 1) {
					target[j]--;
					result++;
				}
			}
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 16, 16, 16 };
		int n = arr.length;
		System.out.println("Minimum number of steps required to get the given target array is " + countMinOperations(arr, n));
	}

}
