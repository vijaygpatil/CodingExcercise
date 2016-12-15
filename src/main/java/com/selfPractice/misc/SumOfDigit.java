package com.selfPractice.misc;

public class SumOfDigit {
	public static void main(String args[]) {
		System.out.println("Sum of digit using recursion for number 123 is " + sumOfDigits(123));
		System.out.println("Sum of digit using recursion for number 1234 is " + sumOfDigits(1234));
		System.out.println("Sum of digit from recursive function for number 321 is " + sumOfDigits(321));
		System.out.println("Sum of digit from recursive method for number 1 is " + sumOfDigits(1));
		System.out.println("Sum of digit using Iteration for number 123 is " + sumOfDigitsIterative(123));
		System.out.println("Sum of digit using while loop for number 1234 is " + sumOfDigitsIterative(1234));
	}

	public static int sumOfDigits(int number) {
		if (number / 10 == 0)
			return number;
		return number % 10 + sumOfDigits(number / 10);
	}

	public static int sumOfDigitsIterative(int number) {
		int result = 0;
		while (number != 0) {
			result = result + number % 10;
			number = number / 10;
		}
		return result;
	}
}
