package com.selfPractice.array;

import java.util.ArrayList;
import java.util.List;

public class JollyJumperSequence {
	// Program for Jolly Jumper Sequence
	// Function to check whether given sequence is
	// Jolly Jumper or not
	static boolean isJolly(int a[], int n) {
		// Boolean vector to diffSet set of differences.
		// The vector is initialized as false.
		List<Boolean> diffSet = new ArrayList<>();

		// Traverse all array elements
		for (int i = 0; i < n - 1; i++) {
			// Find absolute difference between current two
			int d = Math.abs(a[i] - a[i + 1]);

			// If difference is out of range or repeated,
			// return false.
			if (d == 0 || d > n - 1 || diffSet.get(d) == true)
				return false;

			// Set presence of d in set.
			diffSet.set(d, true);
		}

		return true;
	}

	// Driver Code
	public static void main(String[] args) {
		int a[] = { 11, 7, 4, 2, 1, 6 };
		int n = a.length;
		if (isJolly(a, n)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
