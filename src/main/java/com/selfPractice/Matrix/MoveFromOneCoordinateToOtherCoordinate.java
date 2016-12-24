package com.selfPractice.Matrix;

public class MoveFromOneCoordinateToOtherCoordinate {
	// C++ program to check if it is possible to reach
	// (a, b) from (x, y).
	// Returns GCD of i and j
	static int gcd(int i, int j) {
		if (i == j)
			return i;

		if (i > j)
			return gcd(i - j, j);
		return gcd(i, j - i);
	}

	// Returns true if it is possble to go to (a, b)
	// from (x, y)
	static boolean ispossible(int x, int y, int a, int b) {
		// Find absolute values of all as sign doesn't
		// matter.
		x = Math.abs(x);
		y = Math.abs(y);
		a = Math.abs(a);
		b = Math.abs(b);

		// If gcd is equal then it is possible to reach.
		// Else not possible.
		return (gcd(x, y) == gcd(a, b));
	}

	// Driven Program
	public static void main(String[] args) {
		// Converting coordinate into positive integer
		int x = 35, y = 15;
		int a = 20, b = 25;

		if (ispossible(x, y, a, b)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
