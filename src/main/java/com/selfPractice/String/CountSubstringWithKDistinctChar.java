package com.selfPractice.String;

public class CountSubstringWithKDistinctChar {
	public static void main(String[] args) {
		CountSubstringWithKDistinctChar ob = new CountSubstringWithKDistinctChar();
		String ch = "abcbaa";
		int k = 3;
		System.out.println("Total substrings with exactly " + k + " distinct characters : " + ob.countkDist(ch, k));
	}

	int countkDist(String ch, int k) {
		int n = ch.length();
		int res = 0;
		int[] a = new int[26];

		for (int i = 0; i < n; i++) {
			int distCount = 0;
			for (int l = 0; l < a.length; l++) {
				a[l] = 0;
			}

			for (int j = i; j < n; j++) {
				if (a[ch.charAt(j) - 'a'] == 0) {
					distCount++;
				}

				a[ch.charAt(j) - 'a']++;

				if (distCount == k) {
					res++;
					break;
				}
			}
		}
		return res;

	}
}
