package com.selfPractice.String;

public class LongestCommonSequenceWithPermutationZ {
	private static void longestString(String str1, String str2) {
		int[] count1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] count2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		// calculate frequency of characters
		for (int i = 0; i < str1.length(); i++)
			count1[str1.charAt(i) - 'a']++;
		for (int i = 0; i < str2.length(); i++)
			count2[str2.charAt(i) - 'a']++;

		// Now traverse hash array
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 26; i++)

			// append character ('a'+i) in resultant
			// string 'result' by min(count1[i],count2i])
			// times
			for (int j = 1; j <= Math.min(count1[i], count2[i]); j++)
				result.append((char)('a' + i));

		System.out.println(result);
	}

	// Driver program to run the case
	public static void main(String[] args) {
		String str1 = "geeks", str2 = "cakes";
		longestString(str1, str2);
	}
}
