package com.selfPractice.dynamic;

// A Dynamic Programming based Python Program for the Egg Dropping Puzzle
public class LongestPalindromicSequence {

	/* Driver program to test above functions */
	public static void main(String args[]) {
		String seq = "forgeeksskeegfor";
		int n = seq.length();
		System.out.println("The lnegth of the lps is " + lps(seq));
		System.out.println("The lnegth of the lps is " + lps(seq, 0, n - 1));
		System.out.println("The lnegth of the lps is " + longestPalindrome(seq));
	}
	
	// A utility function to get max of two integers
	static int max(int x, int y) {
		return (x > y) ? x : y;
	}

	// Returns the length of the longest palindromic subsequence in seq
	static int lps(String seq) {
		int n = seq.length();
		int i, j, cl;
		int L[][] = new int[n][n]; // Create a table to store results of
									// subproblems

		// Strings of length 1 are palindrome of lentgh 1
		for (i = 0; i < n; i++)
			L[i][i] = 1;

		// Build the table. Note that the lower diagonal values of table are
		// useless and not filled in the process. The values are filled in a
		// manner similar to Matrix Chain Multiplication DP solution (See
		// http://www.geeksforgeeks.org/archives/15553). cl is length of
		// substring
		for (cl = 2; cl <= n; cl++) {
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (seq.charAt(i) == seq.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (seq.charAt(i) == seq.charAt(j))
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = max(L[i][j - 1], L[i + 1][j]);
			}
		}

		return L[0][n - 1];
	}

	// Returns the length of the longest palindromic subsequence in seq
	static int lps(String seq, int i, int j) {
		// Base Case 1: If there is only 1 character
		if (i == j)
			return 1;

		// Base Case 2: If there are only 2 characters and both are same
		if (seq.charAt(i) == seq.charAt(j) && i + 1 == j)
			return 2;

		// If the first and last characters match
		if (seq.charAt(i) == seq.charAt(j))
			return lps(seq, i + 1, j - 1) + 2;

		// If the first and last characters do not match
		return max(lps(seq, i, j - 1), lps(seq, i + 1, j));
	}
	
	public static String longestPalindrome(String s) {
		int n = s.length();
		int low = 0;
		int high = 0;
		int start = low;
		int maxLength = 1;
		for(int i = 1; i < n; i++) {
			low = i - 1;
			high = i;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(high - low + 1 > maxLength ) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
			
			low = i - 1;
			high = i + 1;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(high - low + 1 > maxLength ) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}

		return s.substring(start, start+maxLength);
	}
}
/* This code is contributed by Rajat Mishra */
