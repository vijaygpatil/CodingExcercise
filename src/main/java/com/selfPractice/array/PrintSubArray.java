package com.selfPractice.array;

public class PrintSubArray {
	// Prints all subarrays in arr[0..n-1]
	private static void subArray(int arr[], int n) {
		// Pick starting point
		for (int i = 0; i < n; i++) {
			// Pick ending point
			for (int j = i; j < n; j++) {
				// Print subarray between current starting
				// and ending points
				for (int k = i; k <= j; k++)
					System.out.print(arr[k] + " ");

				System.out.println();
			}
		}
	}

	// Driver program
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int n = arr.length;
		subArray(arr, n);
	}

}
