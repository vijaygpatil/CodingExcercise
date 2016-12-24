package com.selfPractice.Matrix;

public class RotateImage {

	public static void main(String[] args) {
		
		int image[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int m, n;
		m = 3;
		n = 4;
		displayMatrix(image, m, n);
		int[][] destBuffer = rotate(image, m, n);
		displayMatrix(destBuffer, n, m);
	}

	static void displayMatrix(int[][] image, int r, int c) {

		for (int row = 0; row < r; row++) {
			for (int col = 0; col < c; col++)
				System.out.print(image[row][col] + " ");
			System.out.println("");
		}
	}

	static int[][] rotate(int[][] image, int row, int col) {
		int[][] destBuffer = new int[col][row];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				destBuffer[c][row - r - 1] = image[r][c];
			}
		}

		return destBuffer;
	}

}
