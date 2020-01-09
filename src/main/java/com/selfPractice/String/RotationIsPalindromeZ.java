package com.selfPractice.String;

public class RotationIsPalindromeZ {
	// A utility function to check if a string str is palindrome
	static boolean isPalindrome(String str) {
		// Start from leftmost and rightmost corners of str
		int l = 0;
		int h = str.length() - 1;

		// Keep comparing characters while they are same
		while (h > l)
			if (str.charAt(l++) != str.charAt(h--))
				return false;

		// If we reach here, then all characters were matching
		return true;
	}

	// Function to check if a given string is a rotation of a
	// palindrome.
	static boolean isRotationOfPalindrome(String str) {
		// If string it self is palindrome
		if (isPalindrome(str))
			return true;

		// Now try all rotations one by one
		int n = str.length();
		for (int i = 0; i < n - 1; i++) {
			String str1 = str.substring(i + 1, n);
			String str2 = str.substring(0, i + 1);

			System.out.println(str1);
			System.out.println(str2);
			
			// Check if this rotation is palindrome
			if (isPalindrome(str1 + str2))
				return true;
		}
		return false;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		System.out.println(isRotationOfPalindrome("aab"));
		System.out.println(isRotationOfPalindrome("abcde"));
		System.out.println(isRotationOfPalindrome("aaaad"));
	}
}
