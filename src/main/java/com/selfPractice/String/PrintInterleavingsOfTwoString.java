package com.selfPractice.String;

import java.util.Arrays;

public class PrintInterleavingsOfTwoString {
	// The main function that recursively prints all interleavings.
	// The variable iStr is used to store all interleavings (or
	// output strings) one by one.
	// i is used to pass next available place in iStr
	static void printIlsRecur(String str1, String str2, char[] istr, int m, int n, int i) {
		// Base case: If all characters of str1 and str2 have been
		// included in output string, then print the output string
		if (m == 0 && n == 0)
			System.out.println(istr);

		// If some characters of str1 are left to be included, then
		// include the first character from the remaining characters
		// and recur for rest
		if (m != 0) {
			istr[i] = str1.charAt(0);
			printIlsRecur(str1.substring(1), str2, istr, m - 1, n, i + 1);
			
		}

		// If some characters of str2 are left to be included, then
		// include the first character from the remaining characters
		// and recur for rest
		if (n != 0) {
			istr[i] = str2.charAt(0);
			printIlsRecur(str1, str2.substring(1), istr, m, n - 1, i + 1);
		}
	}

	// Allocates memory for output string and uses printIlsRecur()
	// for printing all interleavings
	static void printIls(String str1, String str2, int m, int n) {

		char[] istr = new char[m + n];

		printIlsRecur(str1, str2, istr, m, n, 0);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		printIls("AB", "CD", "AB".length(), "CD".length());
	}
}
