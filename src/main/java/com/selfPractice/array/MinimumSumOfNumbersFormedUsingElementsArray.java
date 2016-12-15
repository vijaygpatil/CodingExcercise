package com.selfPractice.array;

import java.util.Arrays;

public class MinimumSumOfNumbersFormedUsingElementsArray {
	// C++ program to find minimum sum of two numbers
	// formed from digits of the array.

	// Function to find and return minimum sum of
	// two numbers formed from digits of the array.
	static int solve(int arr[], int n) {
		// sort the array
		Arrays.sort(arr);

		// let two numbers be a and b
		int a = 0, b = 0;
		for (int i = 0; i < n; i++) {
			// fill a and b with every alternate digit
			// of input array
			if ((i & 1) == 1)
				a = a * 10 + arr[i];
			else
				b = b * 10 + arr[i];
		}

		// return the sum
		return a + b;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 6, 8, 4, 5, 2, 3 };
		int n = arr.length;
		System.out.println("Sum is " + solve(arr, n));
	}

}
