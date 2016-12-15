package com.selfPractice.array;

public class SmallestSubArrayWithGivenSum {
	// Returns length of smallest subarray with sum greater than x.
	// If there is no subarray with given sum, then returns n+1
	int smallestSubWithSum(int arr[], int n, int x) {
		// Initialize current sum and minimum length
		int curr_sum = 0, min_len = n + 1;

		// Initialize starting and ending indexes
		int start = 0, end = 0;
		while (end < n) {
			// Keep adding array elements while current sum
			// is smaller than x
			while (curr_sum <= x && end < n)
				curr_sum += arr[end++];

			// If current sum becomes greater than x.
			while (curr_sum > x && start < n) {
				// Update minimum length if needed
				if (end - start < min_len)
					min_len = end - start;

				// remove starting elements
				curr_sum -= arr[start++];
			}
		}
		return min_len;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		SmallestSubArrayWithGivenSum array_sum = new SmallestSubArrayWithGivenSum();
		int arr1[] = { 1, 4, 45, 6, 10, 19 };
		int x = 51;
		int n1 = arr1.length;
		System.out.println(array_sum.smallestSubWithSum(arr1, n1, x));

		int arr2[] = { 1, 10, 5, 2, 7 };
		int n2 = arr2.length;
		x = 9;
		System.out.println(array_sum.smallestSubWithSum(arr2, n2, x));

		int arr3[] = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
		int n3 = arr3.length;
		x = 280;
		System.out.println(array_sum.smallestSubWithSum(arr3, n3, x));
	}
}

// This code has been contributed by Mayank Jaiswal
