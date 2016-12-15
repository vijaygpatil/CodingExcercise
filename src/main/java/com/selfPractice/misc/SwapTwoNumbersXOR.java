package com.selfPractice.misc;

public class SwapTwoNumbersXOR {
	public static void main(String[] args) {
		int a = 2; // 0010 in binary
		int b = 4; // 0100 in binary

		System.out.println("value of a and b before swapping, a: " + a + " b: " + b);

		// swapping value of two numbers without using temp variable and XOR
		// bitwise operator
		a = a ^ b; // now a is 6 and b is 4
		b = a ^ b; // now a is 6 but b is 2 (original value of a)
		a = a ^ b; // now a is 4 and b is 2, numbers are swapped

		System.out.println("value of a and b after swapping using XOR bitwise operation, a: " + a + " b: " + b);
	}
}
