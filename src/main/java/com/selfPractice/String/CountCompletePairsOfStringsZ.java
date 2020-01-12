package com.selfPractice.String;

public class CountCompletePairsOfStringsZ {
	// Returns count of complete pairs from set[0..n-1] and set2[0..m-1]
	private static int countCompletePairs(String[] set1, String[] set2, int n, int m) {
		int result = 0;

		// Consider all pairs of both strings
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// Create a concatenation of current pair
				String concat = set1[i] + set2[j];

				// Compute frequencies of all characters
				// in the concatenated string.
				int[] frequency = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				
				for (int k = 0; k < concat.length(); k++)
					frequency[concat.charAt(k) - 'a']++;

				// If frequency of any character is not
				// greater than 0, then this pair is not
				// complete.
				int l;
				for (l = 0; l < 26; l++)
					if (frequency[l] < 1)
						break;
				if (l == 26)
					result++;
			}
		}

		return result;
	}

	// Driver code
	public static void main(String[] args) {
		String[] set1 = { "abcdefgh", "geeksforgeeks", "lmnopqrst", "abc" };
		String[] set2 = { "ijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz", "defghijklmnopqrstuvwxyz" };
		int n = set1.length;
		int m = set2.length;

		System.out.println(countCompletePairs(set1, set2, n, m));
	}
}
