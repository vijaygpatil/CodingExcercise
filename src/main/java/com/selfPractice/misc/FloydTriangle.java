package com.selfPractice.misc;

import java.util.Scanner;

/**
 * Java program to print Floyd's triangle up-to a given row
 *
 * @author Javin Paul
 */
public class FloydTriangle {

	public static void main(String args[]) {
		Scanner cmd = new Scanner(System.in);
		System.out.println("Enter the number of rows of Floyd's triangle, you want to display");
		int rows = cmd.nextInt();
		printFloydTriangle(rows);

	}

	/**
	 * Prints Floyd's triangle of a given row
	 *
	 * @param rows
	 */
	public static void printFloydTriangle(int rows) {
		int number = 1;
		System.out.printf("Floyd's triangle of %d rows is : %n", rows);

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(number + " ");
				number++;
			}

			System.out.println();
		}
	}
}