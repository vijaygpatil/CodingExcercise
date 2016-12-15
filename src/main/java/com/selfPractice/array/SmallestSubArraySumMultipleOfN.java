package com.selfPractice.array;

public class SmallestSubArraySumMultipleOfN {
	// C++ program to find subarray whose sum
	// is multiple of size
	// Method prints smallest subarray whose sum is
	// multiple of size
	static void printSubarrayMultipleOfN(int arr[], int N) {
		// A direct index table to see if sum % N
		// has appeared before or not.
		int[] modIdx = new int[N];

		// initialize all mod index with -1
		for (int i = 0; i < N; i++)
			modIdx[i] = -1;

		// initializing minLen and curLen with larger
		// values
		int minLen = N + 1;
		int curLen = N + 1;

		// To store sum of array elements
		int sum = 0;

		// looping for each value of array
		int l = 0, r = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			sum %= N;

			// If this is the first time we have
			// got mod value as 0, then S(0, i) % N
			// == 0
			if (modIdx[sum] == -1 && sum == 0)
				curLen = i + 1;

			// If we have reached this mod before then
			// length of subarray will be i - previous_position
			if (modIdx[sum] != -1)
				curLen = i - modIdx[sum];

			// choose minimum length os subarray till now
			if (curLen < minLen) {
				minLen = curLen;

				// update left and right indices of subarray
				l = modIdx[sum] + 1;
				r = i;
			}
			modIdx[sum] = i;
		}

		// print subarray
		for (int i = l; i <= r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver code to test above method
	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 4, 2 };
		int N = arr.length;

		printSubarrayMultipleOfN(arr, N);
	}

}
