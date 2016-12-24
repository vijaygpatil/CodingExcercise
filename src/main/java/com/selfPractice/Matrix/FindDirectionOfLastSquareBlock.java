package com.selfPractice.Matrix;

public class FindDirectionOfLastSquareBlock {
	// C++ program to tell the Current direction in R x C grid
	int ll;

	// Function which tells the Current direction
	static void direction(int R, int C) {
		if (R != C && R % 2 == 0 && C % 2 != 0 && R < C) {
			System.out.println("Left");
			return;
		}
		if (R != C && R % 2 != 0 && C % 2 == 0 && R > C) {
			System.out.println("Up");
			return;
		}
		if (R == C && R % 2 != 0 && C % 2 != 0) {
			System.out.println("Right");
			return;
		}
		if (R == C && R % 2 == 0 && C % 2 == 0) {
			System.out.println("Left");
			return;
		}
		if (R != C && R % 2 != 0 && C % 2 != 0 && R < C) {
			System.out.println("Right");
			return;
		}
		if (R != C && R % 2 != 0 && C % 2 != 0 && R > C) {
			System.out.println("Down");
			return;
		}
		if (R != C && R % 2 == 0 && C % 2 == 0 && R < C) {
			System.out.println("Left");
			return;
		}
		if (R != C && R % 2 == 0 && C % 2 == 0 && R > C) {
			System.out.println("Up");
			return;
		}
		if (R != C && R % 2 == 0 && C % 2 != 0 && R > C) {
			System.out.println("Down");
			return;
		}
		if (R != C && R % 2 != 0 && C % 2 == 0 && R < C) {
			System.out.println("Right");
			return;
		}
	}

	// Driver program to test the Cases
	public static void main(String[] args) {
		int R = 3, C = 1;
		direction(R, C);
	}
}
