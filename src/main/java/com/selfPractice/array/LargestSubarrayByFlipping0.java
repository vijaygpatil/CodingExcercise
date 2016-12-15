package com.selfPractice.array;

public class LargestSubarrayByFlipping0 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 0, 1, 1, 0 };
		int n = arr.length;
		System.out.println(findMaxZeroCount(arr, n));
	}

	static int findMaxZeroCount(int[] a, int n) {
		int orig_count_zero = 0;
		int cur_sum = 0;
		int max_diff = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				orig_count_zero++;
			}
			int val = (a[i] == 1) ? 1 : -1;
			cur_sum = Math.max(val, cur_sum + val);
			max_diff = Math.max(cur_sum, max_diff);
		}

		max_diff = Math.max(0, max_diff);
		return orig_count_zero + max_diff;
	}
	
	// continuous sequence of 1s. If there is no 0 in array, then
	// it returns -1.
	static int maxOnesIndex(int arr[], int n)
	{
		int max_count = 0; // for maximum number of 1 around a zero
		int max_index=0; // for storing result
		int prev_zero = -1; // index of previous zero
		int prev_prev_zero = -1; // index of previous to previous zero

		// Traverse the input array
		for (int curr=0; curr<n; ++curr)
		{
			// If current element is 0, then calculate the difference
			// between curr and prev_prev_zero
			if (arr[curr] == 0)
			{
				// Update result if count of 1s around prev_zero is more
				if (curr - prev_prev_zero > max_count)
				{
					max_count = curr - prev_prev_zero;
					max_index = prev_zero;
				}

				// Update for next iteration
				prev_prev_zero = prev_zero;
				prev_zero = curr;
			}
		}

		// Check for the last encountered zero
		if (n-prev_prev_zero > max_count)
			max_index = prev_zero;

		return max_index;
	}
}
