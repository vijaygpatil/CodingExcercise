package com.selfPractice.String;

public class GenerateAllBinaryStringsZ {
	public static void main(String[] args) {

		String str = "1??0?101";

		print(str.toCharArray(), 0);
	}

	static void print(char[] str, int index) {
		if (index == str.length) {
			System.out.println(str);
			return;
		}

		if (str[index] == '?') {
			str[index] = '0';
			print(str, index + 1);

			str[index] = '1';
			print(str, index + 1);
		} else
			print(str, index + 1);
	}
}
