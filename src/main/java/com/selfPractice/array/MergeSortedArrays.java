package com.selfPractice.array;

public class MergeSortedArrays {
	// C++ program for implementation of Sieve of Atkin
	// Merge ar1[] and ar2[] with O(1) extra space
	static void merge(int ar1[], int ar2[], int m, int n) {
		// Iterate through all elements of ar2[] starting from
		// the last element
		for (int i = n - 1; i >= 0; i--) {
			/*
			 * Find the smallest element greater than ar2[i]. Move all elements
			 * one position ahead till the smallest greater element is not found
			 */
			int j, last = ar1[m - 1];
			for (j = m - 1; j >= 0 && ar1[j] > ar2[i]; j--)
				ar1[j] = ar1[j-1];

			// If there was a greater element
			if (j != m - 1) {
				ar1[j + 1] = ar2[i];
				ar2[i] = last;
			}
		}
	}

	// Driver program
	public static void main(String[] args) {
		int ar1[] = { 1, 5, 9, 10, 15, 20 };
		int ar2[] = { 2, 3, 8, 13 };
		int m = ar1.length;
		int n = ar2.length;
		merge(ar1, ar2, m, n);

		System.out.println("First Array: ");
		for (int i = 0; i < m; i++)
			System.out.print(ar1[i] + " ");
		System.out.println("");
		System.out.println("Second Array: ");
		for (int i = 0; i < n; i++)
			System.out.println(ar2[i] + " ");
	}

}
