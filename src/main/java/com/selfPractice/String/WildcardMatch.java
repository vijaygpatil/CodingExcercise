package com.selfPractice.String;

public class WildcardMatch {
	public static void main(String[] args) {
		System.out.println(isMatch("a", "aa"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aa", "aaa"));
		System.out.println(isMatch("*", "aa"));
		System.out.println(isMatch("a*", "aa"));
		System.out.println(isMatch("?*", "ab"));
		System.out.println(isMatch("c*a*b", "aab"));
		System.out.println(isMatch("g*ks", "geeks")); // Yes
		System.out.println(isMatch("ge?ks*", "geeksforgeeks")); // Yes
		System.out.println(isMatch("g*k", "gee")); // No because 'k' is not in
													// second
		System.out.println(isMatch("*pqrs", "pqrst")); // No because 't' is not
														// in first
		System.out.println(isMatch("abc*bcd", "abcdhghgbcd")); // Yes
		System.out.println(isMatch("abc*c?d", "abcd")); // No because second
														// must have 2 instances
														// of 'c'
		System.out.println(isMatch("*c*d", "abcd")); // Yes
		System.out.println(isMatch("*?c*d", "abcd")); // Yes
	}

	public static boolean isMatch(String p, String s) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;

		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}

		return j == p.length();
	}
}
