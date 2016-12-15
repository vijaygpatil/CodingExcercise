package com.selfPractice.String;

public class LongestPalidrome {
	public static void main(String[] args) {
		String s = "forgeeksskeegfor";
		System.out.println(longestPalindrome(s));
	}
	
	public static String longestPalindrome(String s) {
		int n = s.length();
		int low = 0;
		int high = 0;
		int start = low;
		int maxLength = 1;
		for(int i = 1; i < n; i++) {
			low = i - 1;
			high = i;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(high - low + 1 > maxLength ) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
			
			low = i - 1;
			high = i + 1;
			while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if(high - low + 1 > maxLength ) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}

		return s.substring(start, start+maxLength);
	}
}
