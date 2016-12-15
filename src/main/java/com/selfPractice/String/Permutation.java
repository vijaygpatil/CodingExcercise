package com.selfPractice.String;

public class Permutation {
	// print n! permutation of the characters of the string s (in order)
	public static void perm1(String s) {
		perm1("", s);
	}

	private static void perm1(String prefix, String s) {
		int n = s.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
		}

	}

	// print n! permutation of the elements of array a (not in order)
	public static void perm2(String s) {
		int n = s.length();
		char[] a = new char[n];
		for (int i = 0; i < n; i++)
			a[i] = s.charAt(i);
		perm2(a, n);
	}

	private static void perm2(char[] a, int n) {
		if (n == 1) {
			System.out.println(a);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(a, i, n - 1);
			perm2(a, n - 1);
			swap(a, i, n - 1);
		}
	}

	// swap the characters at indices i and j
	private static void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
	
	public static void permutationWithRepetitionOfCharacters(String s) {
		int n = s.length();
		char[] schar = s.toCharArray();
		char[] data = new char[n];
		permute(schar, data, 0, n);
	}
	
	public static void permute(char[] schar, char[] data, int i, int n) {
		for(int j = 0; j <= n-1; j++) {
			data[i] = schar[j];
			
			if(i == n-1) {
				System.out.println(data);
			} else {
				permute(schar, data, i + 1, n);
			}
		}
	}

	public static void main(String[] args) {
		String alphabet = "ABC";
		perm1(alphabet);
		System.out.println();
		//perm2(alphabet);
		alphabet = "ABC";
		//permutationWithRepetitionOfCharacters(alphabet);
	}
}
