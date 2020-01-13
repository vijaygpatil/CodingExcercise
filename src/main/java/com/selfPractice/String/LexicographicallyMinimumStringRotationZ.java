package com.selfPractice.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicallyMinimumStringRotationZ {
	// A simple C++ program to find lexicographically minimum rotation
	// of a given string

	// This function return lexicographically minimum
	// rotation of str
	static String minLexRotation(String str) {
		// Find length of given string
		int n = str.length();

		// Create an array of strings to store all rotations
		List<String> arr = new ArrayList<>();

		// Create a concatenation of string with itself
		String concat = str + str;

		// One by one store all rotations of str in array.
		// A rotation is obtained by getting a substring of concat
		for (int i = 0; i <= n-1; i++)
			arr.add(concat.substring(i, n+i));

		// Sort all rotations
		Collections.sort(arr, ALPHABETICAL_ORDER);

		// Return the first rotation from the sorted array
		return arr.get(0);
	}

	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
		public int compare(String str1, String str2) {
			int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
			if (res == 0) {
				res = str1.compareTo(str2);
			}
			return res;
		}
	};

	// Driver program to test above function
	public static void main(String[] args) {
		System.out.println(minLexRotation("GEEKSFORGEEKS"));
		System.out.println(minLexRotation("GEEKSQUIZ"));
		System.out.println(minLexRotation("BCABDADAB"));
	}

}
