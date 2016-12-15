package com.selfPractice.misc;

public class GenerateBinaryPermutationsWithMoreOrEqualNumbersOfOne {
	// C++ program to generate all permutations of 1's and 0's such that
	// every permutation has more 1's than 0's at all indexes.
	// ones & zeroes --> counts of 1's and 0's in current string 'str'
	// len ---> desired length of every permutation
	static void generate(int ones, int zeroes, String str, int len) {
		// If length of current string becomes same as desired length
		if (len == str.length()) {
			System.out.println(str + " ");
			return;
		}

		// Append a 1 and recur
		generate(ones + 1, zeroes, str + "1", len);

		// If there are more 1's, append a 0 as well, and recur
		if (ones > zeroes)
			generate(ones, zeroes + 1, str + "0", len);
	}

	// Driver program to test above function
	public static void main(String[] args) {
		String str = "";
		generate(0, 0, str, 4);
	}

}
