 package com.selfPractice.String;

public class WordCountZ {
	public static void main(String[] args) {
		char str[] = "One two          three\n  four\nfive  ".toCharArray();
		System.out.println("No of words: " + countWords(str));
	}

	private static int countWords(char[] str) {
		int out = 0;
		int in = 1;
		int n = str.length;
		int state = out;
		int i = 0;
		int wc = 0;
		
		while(i < n) {
			
			if(str[i] == ' ' || str[i] == '\n' || str[i] == '\t') {
				state = out;
			} else if(state == out) {
				state = in;
				++wc;
			}
			i++;
		}
		
		return wc;
	}
}
