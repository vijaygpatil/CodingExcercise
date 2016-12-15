package com.selfPractice.String;

public class RunLengthEncoded {
	public static void main(String[] args) {
		String s = "wwwwaaadexxxxxx";
		printRunLengthEncoded(s);
	}
	
	static void printRunLengthEncoded(String s) {
		int n = s.length();
		int[] count = new int[256];
		for(int i = 0; i <= n - 1; i++) {
			count[s.charAt(i)]++;
		}
		
		for(int i = 0; i < count.length-1; i++) {
			System.out.print(count[i]);
		}
		System.out.println();
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i <= n - 1; i++) {
			builder.append(s.charAt(i));
			builder.append(count[s.charAt(i)]);
			while(i < n - 1 && s.charAt(i) == s.charAt(i+1)) i++;
		}
		
		System.out.println(builder.toString());
	}
}