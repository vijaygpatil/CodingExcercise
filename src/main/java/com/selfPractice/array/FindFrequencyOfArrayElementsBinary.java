package com.selfPractice.array;

import java.util.ArrayList;
import java.util.List;

public class FindFrequencyOfArrayElementsBinary {
	// C++ program to count number of occurrences of
	// each element in the array in less than O(n) time

	// A recursive function to count number of occurrences
	// for each element in the array without traversing
	// the whole array
	static void findFrequencyUtil(int arr[], int low, int high, List<Integer> freq) {
		// If element at index low is equal to element
		// at index high in the array
		if (arr[low] == arr[high]) {
			// increment the frequency of the element
			// by count of elements between high and low
			freq.set(arr[low], freq.get(arr[low])+ high - low + 1);
		} else {
			// Find mid and recurse for left and right
			// subarray
			int mid = (low + high) / 2;
			findFrequencyUtil(arr, low, mid, freq);
			findFrequencyUtil(arr, mid + 1, high, freq);
		}
	}

	// A wrapper over recursive function
	// findFrequencyUtil(). It print number of
	// occurrences of each element in the array.
	static void findFrequency(int arr[], int n) {
		// create a empty vector to store frequencies
		// and initialize it by 0. Size of vector is
		// maximum value (which is last value in sorted
		// array) plus 1.
		List<Integer> freq = new ArrayList<>();

		// Fill the vector with frequency
		findFrequencyUtil(arr, 0, n - 1, freq);

		// Print the frequencies
		for (int i = 0; i <= arr[n - 1]; i++)
			if (freq.get(i) != 0)
				System.out.println("Element " + i + " occurs " + freq.get(i) + " times");
	}

	// Driver function
	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10 };
		int n = arr.length;

		findFrequency(arr, n);
	}

}
