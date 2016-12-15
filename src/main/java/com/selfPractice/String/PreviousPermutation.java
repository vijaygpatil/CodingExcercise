package com.selfPractice.String;

public class PreviousPermutation {
	public static void main(String[] args) {
		String a = "3456346345634";
		findPreviousPermutation(a);
	}

	static void findPreviousPermutation(String a) {

		char[] s = a.toCharArray();

		int n = s.length - 1;

		int i = n;
		while (i > 0 && Character.getNumericValue(s[i - 1]) <= Character.getNumericValue(s[i])) {
			i--;
		}

		System.out.println(i);

		if (i <= 0) {
			System.out.println("No such Permutation.");
			return ;
		}

		int j = i - 1;
		while (j + 1 <= n && Character.getNumericValue(s[j + 1]) <= Character.getNumericValue(s[i-1])) {
			j++;
		}

		char t = s[i - 1];
		s[i - 1] = s[j];
		s[j] = t;

		for (char c : s) {
			System.out.print(c);
		}
	}
}
