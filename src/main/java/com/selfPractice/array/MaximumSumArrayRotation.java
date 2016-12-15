package com.selfPractice.array;

/*
 * Let us calculate initial value of i*arr[i] with no rotation R0 = 0*arr[0] +
 * 1*arr[1] +...+ (n-1)*arr[n-1]
 * 
 * After 1 rotation arr[n-1], becomes first element of array, arr[0] becomes
 * second element, arr[1] becomes third element and so on. R1 = 0*arr[n-1] +
 * 1*arr[0] +...+ (n-1)*arr[n-2]
 * 
 * R1 - R0 = arr[0] + arr[1] + ... + arr[n-2] - (n-1)*arr[n-1]
 * 
 * After 2 rotations arr[n-2], becomes first element of array, arr[n-1] becomes
 * second element, arr[0] becomes third element and so on. R2 = 0*arr[n-2] +
 * 1*arr[n-1] +...+ (n?1)*arr[n-3]
 * 
 * R2 - R1 = arr[0] + arr[1] + ... + arr[n-3] - (n-1)*arr[n-2] + arr[n-1]
 * 
 * If we take a closer look at above values, we can observe below pattern
 * 
 * Rj - Rj-1 = arrSum - n * arr[n-j]
 * 
 * Where arrSum is sum of all array elements, i.e.,
 * 
 * arrSum = ∑ arr[i] i<=0<=n-1
 */
public class MaximumSumArrayRotation {
	// C++ program to find max value of i*arr[i]
	// Returns max possible value of i*arr[i]
	static int maxSum(int arr[], int n) {
		// Find array sum and i*arr[i] with no rotation
		int arrSum = 0; // Stores sum of arr[i]
		int currVal = 0; // Stores sum of i*arr[i]
		for (int i = 0; i < n; i++) {
			arrSum = arrSum + arr[i];
			currVal = currVal + (i * arr[i]);
		}

		// Initialize result as 0 rotation sum
		int maxVal = currVal;

		// Try all rotations one by one and find
		// the maximum rotation sum.
		for (int j = 1; j < n; j++) {
			currVal = currVal + arrSum - n * arr[n - j];
			if (currVal > maxVal)
				maxVal = currVal;
		}

		// Return result
		return maxVal;
	}

	// Driver program
	public static void main(String[] args) {
		int arr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length;
		System.out.println("Max sum is " + maxSum(arr, n));
	}
}
