package com.selfPractice.String;

public class PossibleStringsByPlacingSpaces {
	// C++ program to print permutations of a given string with spaces.

	/*
	 * Function recursively prints the strings having space pattern. i and j are
	 * indices in 'str[]' and 'buff[]' respectively
	 */
	static void printPatternUtil(String str, char buff[], int i, int j, int n) {
		if (i == n) {

			System.out.println(buff);
			return;
		}

		// Either put the character
		buff[j] = str.charAt(i);
		printPatternUtil(str, buff, i + 1, j + 1, n);

		// Or put a space followed by next character
		buff[j] = ' ';
		buff[j + 1] = str.charAt(i);

		printPatternUtil(str, buff, i + 1, j + 2, n);
	}

	// This function creates buf[] to store individual output string and uses
	// printPatternUtil() to print all permutations.
	static void printPattern(String str) {
		int n = str.length();

		// Buffer to hold the string containing spaces
		char[] buf = new char[2 * n]; // 2n-1 characters and 1 string terminator

		// Copy the first character as it is, since it will be always
		// at first position
		buf[0] = str.charAt(0);

		printPatternUtil(str, buf, 1, 1, n);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		String str = "ABCD";
		printPattern(str);
	}

}
