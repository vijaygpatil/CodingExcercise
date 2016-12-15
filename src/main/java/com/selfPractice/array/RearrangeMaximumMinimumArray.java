package com.selfPractice.array;

public class RearrangeMaximumMinimumArray {
	// C++ program to rearrange an array in minimum maximum form
	// using O(1) space.

	// Puts max at first position, min at second position
	// second max at third position, second min at fourth
	// position and so on.
	static void rearrange(int arr[], int n) {
		// Traverse through all numbers
		for (int i = 0; i < n; i++) {
			int temp = arr[i];

			// If number is negative then we have already
			// processed it. Else process all numbers which
			// are to be replaced by each other in cyclic way
			while (temp > 0) {
				// Find the index where arr[i] should go
				int j = (i < n / 2) ? 2 * i + 1 : 2 * (n - 1 - i);

				// If arr[i] is already at its correct
				// position, mark it as negative
				if (i == j) {
					arr[i] = -temp;
					break;
				}

				// Swap the number 'temp' with the current number
				// at its target position
				int t = temp;
				temp = arr[j];
				arr[j] = t;

				// Mark the number as processed
				arr[j] = -arr[j];

				// Next process the previous number at target position
				i = j;
			}
		}

		// Change the number to original value
		for (int i = 0; i < n; i++)
			arr[i] = -arr[i];
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int n = arr.length;
		System.out.println("Original Array\n");
		for (int i = 0; i < n; i++)
			System.out.println(arr[i] + " ");

		rearrange(arr, n);

		System.out.println("Modified Array");
		for (int i = 0; i < n; i++)
			System.out.println(arr[i] + " ");
	}

}
