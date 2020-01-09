package com.selfPractice.String;

public class ReverseStringZ {
	public static void main(String[] args) {
		String s = "I like this program very much";
		reverseString(s);
		reverseWords(s);
	}

	private static void reverseWords(String s) {
		String[] sList = s.split(" ");
		int n = sList.length;
		
		StringBuilder builder = new StringBuilder();
		for(int i = n - 1; i >= 0; i-- ) {
			builder.append(sList[i]);
			builder.append(" ");
		}
		System.out.println(builder.toString().trim());
	}

	private static void reverseString(String s) {
		String[] sList = s.split(" ");
		int n = sList.length;
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < n; i++ ) {
			builder.append(reverse(sList[i]));
			builder.append(" ");
		}
		System.out.println(builder.toString().trim());
	}
	
	public static String reverse(String str) {
		if(str.length() == 1) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
}
