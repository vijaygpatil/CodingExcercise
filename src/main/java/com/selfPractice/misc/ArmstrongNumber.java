package com.selfPractice.misc;

import java.util.Scanner;

/**
 * * This Java program computes all Armstrong numbers in the range of 0 and
 * 9999. An * Armstrong number is a number such that the sum of its digits
 * raised to the * third power is equal to the number itself. For example, 153
 * is an Armstrong * number, since 1**3 + 5**3 + 3**3 = 153. * * @author Javin
 * Paul
 */
public class ArmstrongNumber {
	public static void main(String args[]) {
		Scanner cmd = new Scanner(System.in);
		System.out.println("Please enter a number up-to which Armstrong number will be find");
		int count = cmd.nextInt();
		int index = 0;
		for (int i = 0; i < count; i++) {
			if (isArmstrongNumber(i)) {
				System.out.printf("Armstrong number %d: %d %n", index, i);
				index++;
			}
		}
		cmd.close();
	}

	/**
	 * * Java Method to check if given number is Armstrong Number or not *
	 * * @param number * @return true, if Armstrong number, false otherwise.
	 */
	public static boolean isArmstrongNumber(int number) {
		int sum = 0;
		int copyOfInput = number;
		while (copyOfInput != 0) {
			int lastDigit = copyOfInput % 10;
			sum += (lastDigit * lastDigit * lastDigit);
			copyOfInput /= 10;
		}
		if (sum == number) {
			return true;
		}
		return false;
	}
}
