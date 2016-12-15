package com.selfPractice.misc;

public class CountSetBits {
	// A simple program to count set bits in all numbers from 1 to n.

	// A utility function to count set bits in a number x
	// int countSetBitsUtil(int x);

	// Returns count of set bits present in all numbers from 1 to n
	static int countSetBits(int n) {
		int bitCount = 0; // initialize the result

		for (int i = 1; i <= n; i++)
			bitCount += countSetBitsUtil(i);

		return bitCount;
	}

	// A utility function to count set bits in a number x
	static int countSetBitsUtil(int x) {
		if (x <= 0)
			return 0;
		return (x % 2 == 0 ? 0 : 1) + countSetBitsUtil(x / 2);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Total set bit count is: " + countSetBits(n));
	}

}
