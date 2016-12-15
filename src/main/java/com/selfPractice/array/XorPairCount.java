package com.selfPractice.array;

import java.util.HashSet;
import java.util.Set;

public class XorPairCount {
	private static int xorPairCount(int arr[], int n, int x) {
		int result = 0; // Initialize result
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (s.contains(x ^ arr[i]))
				result++;
			s.add(arr[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 4, 10, 15, 7, 6 };
		int n = arr.length;
		int x = 5;
		System.out.println("Count of Pairs: " + xorPairCount(arr, n, x));
	}
}