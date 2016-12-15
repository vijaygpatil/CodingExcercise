package com.selfPractice.misc;

public class SwapTwoNumbersUsingMultiplicationDivision {
	public static void main(String[] args) {
		int a = 6;
		int b = 3;

		System.out.println("value of a and b before swapping, a: " + a + " b: " + b);

		// swapping value of two numbers without using temp variable using
		// multiplication and division
		a = a * b; // now a is 18 and b is 3
		b = a / b; // now a is 18 but b is 6 (original value of a)
		a = a / b; // now a is 3 and b is 6, numbers are swapped

		System.out.println("value of a and b after swapping using multiplication and division, a: " + a + " b: " + b);

	}
}
