package com.selfPractice.array;

public class SumOfAbsoluteDifferencesOfPairs {
	/*
	 * For example in {1,2,3,4} element at index 2 is arr[2] = 3 so all pairs
	 * having 3 as one element will be (1,3), (2,3) and (3,4), now when we take
	 * summation of absolute difference of pairs, then for all pairs in which 3
	 * is present as one element summation will be = (3-1)+(3-2)+(4-3). We can
	 * see that 3 is added i = 2 times and subtracted n-1-i = (4-1-2) = 1 times.
	 */
	private static int sumPairs(int arr[], int n) {
		int sum = 0;
		for (int i = n - 1; i >= 0; i--)
			sum += i * arr[i] - (n - 1 - i) * arr[i];
		return sum;
	}

	// Driver program to run the case
	public static void main(String[] args) {
		int arr[] = { 1, 8, 9, 15, 16 };
		int n = arr.length;
		System.out.println(sumPairs(arr, n));
	}
}
