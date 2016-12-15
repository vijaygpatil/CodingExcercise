package com.selfPractice.array;

public class MaximumProductOfSubArray {
	// C++ program to find maximum product subarray

	// Function for maximum product
	static int max_product(int arr[], int n) {
		// Initialize maximum products in forward and
		// backward directions
		int max_fwd = Integer.MIN_VALUE, max_bkd = Integer.MIN_VALUE;

		// Initialize current product
		int max_till_now = 1;

		// max_fwd for maximum contiguous product in
		// forward direction
		// max_bkd for maximum contiguous product in
		// backward direction
		// iterating within forward direction in array
		for (int i = 0; i < n; i++) {
			// if arr[i]==0, it is breaking condition
			// for contiguos subarray
			max_till_now = max_till_now * arr[i];
			if (max_till_now == 0) {
				max_till_now = 1;
				continue;
			}
			if (max_fwd < max_till_now) // update max_fwd
				max_fwd = max_till_now;
		}

		max_till_now = 1;

		// iterating within backward direction in array
		for (int i = n - 1; i >= 0; i--) {
			max_till_now = max_till_now * arr[i];
			if (max_till_now == 0) {
				max_till_now = 1;
				continue;
			}

			// update max_bkd
			if (max_bkd < max_till_now)
				max_bkd = max_till_now;
		}

		// return max of max_fwd and max_bkd
		int res = Math.max(max_fwd, max_bkd);

		// Product should not be nagative.
		// (Product of an empty subarray is
		// considered as 0)
		return Math.max(res, 0);
	}

	// Driver Program to test above function
	public static void main(String[] args) {
		int arr[] = { -1, -2, -3, 4 };
		int n = arr.length;
		System.out.println(max_product(arr, n));
	}

}
