package com.selfPractice.String;

import java.util.HashSet;
import java.util.Set;

public class CheckStringPatternZ {
	public static void main(String[] args) {
		String str = "engineers rock";
		String pattern = "oc";
		System.out.println(checkPattern(str, pattern));
		System.out.println(followsPattern(str, pattern));
	}

	public static boolean checkPattern(String str, String pattern) {
		int[] label = new int[256];
		for (int i = 0; i < label.length; i++) {
			label[i] = -1;
		}

		int order = 1;
		for (int i = 0; i < pattern.length(); i++) {
			label[pattern.charAt(i)] = order;
			order++;
		}

		int last_order = -1;
		for (int i = 0; i < str.length(); i++) {
			if (label[str.charAt(i)] != -1) {
				if (label[str.charAt(i)] < last_order) {
					return false;
				}
				last_order = label[str.charAt(i)];
			}
		}
		return true;
	}

	public static boolean followsPattern(String str, String pattern) {
		// Insert all characters of pattern in a hash set,
		Set<Character> patternSet = new HashSet<>();
		for (int i = 0; i < pattern.length(); i++)
			patternSet.add(pattern.charAt(i));

		// Build modified string (string with characters only from
		// pattern are taken)
		StringBuilder modifiedString = new StringBuilder(str);
		for (int i = str.length() - 1; i >= 0; i--)
			if (!patternSet.contains(modifiedString.charAt(i)))
				modifiedString.deleteCharAt(i);

		// Remove more than one consecutive occurrences of pattern
		// characters from modified string.
		for (int i = modifiedString.length() - 1; i > 0; i--)
			if (modifiedString.charAt(i) == modifiedString.charAt(i - 1))
				modifiedString.deleteCharAt(i);

		// After above modifications, the length of modified string
		// must be same as pattern length
		if (pattern.length() != modifiedString.length())
			return false;

		// And pattern characters must also be same as modified string
		// characters
		for (int i = 0; i < pattern.length(); i++)
			if (pattern.charAt(i) != modifiedString.charAt(i))
				return false;

		return true;
	}
}
