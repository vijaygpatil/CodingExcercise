package com.selfPractice.String;

public class InterleavedSequence {
	public static void main(String[] args) {
		String s1 = "AB";
		String s2 = "CD";
		printInterleavedSeq(s1, s2);
		checkInterleaved(s1, s2, "BACD");
	}
	
	static void printInterleavedSeq(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		char[] s1char = s1.toCharArray();
		char[] s2char = s2.toCharArray();
		char[] data = new char[m+n];
		printSeq(s1char, s2char, data, 0, m, n);
	}
	
	static void printSeq(char[] s1, char[] s2, char[] data, int index, int m, int n) {
		if (m == 0 && n == 0) {
			System.out.println(data);
		}

		if (m != 0) {
			data[index] = s1[0];
			printSeq(s1, s2, data, index + 1, m - 1, n);
		}

		if (n != 0) {
			data[index] = s2[0];
			printSeq(s1, s2, data, index + 1, m, n - 1);
		}
	}
	
	static boolean checkInterleaved(String s1, String s2, String s3) {
		char[] s1char = s1.toCharArray();
		char[] s2char = s2.toCharArray();
		char[] s3char = s3.toCharArray();
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		if(s1.length() + s2.length() != s3.length()) {
			System.out.println("NOT INTERLEAVED");
			return false;
		}
		
		while(k < s3char.length) {
			if(i < s1.length() && s1char[i] == s3char[k]) {
				i++;
			} else if(j < s2.length() && s2char[j] == s3char[k]) {
				j++;
			} else {
				System.out.println("NOT INTERLEAVED");
				return false;
			}
			k++;
		}
		
		System.out.println("INTERLEAVED");
		return true;
	}
}
