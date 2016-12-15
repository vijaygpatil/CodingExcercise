package com.selfPractice.String;

public class PermuteUpperCaseLowerCase {

	static void toggler(char[] x, int index, int pos) {
		if (index == pos) {
			System.out.println(new String(x));
			return;
		}

		x[index] = Character.toUpperCase(x[index]);
		toggler(x, index + 1, pos);
		x[index] = Character.toLowerCase(x[index]);
		toggler(x, index + 1, pos);

	}

	public static void main(String[] args) {
		String str = "ABC";
		toggler(str.toCharArray(), 0, str.length());
	}
}
