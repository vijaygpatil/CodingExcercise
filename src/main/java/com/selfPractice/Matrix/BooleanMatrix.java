package com.selfPractice.Matrix;
public class BooleanMatrix {

	public static void modifyMatrix(Integer mat[][]) {
		int[] row = new int[mat.length];
		int[] col = new int[mat[0].length];

		int i, j;

		for (i = 0; i < row.length; i++) {
			row[i] = 0;
		}

		for (i = 0; i < col.length; i++) {
			col[i] = 0;
		}

		for (i = 0; i < row.length; i++) {
			for (j = 0; j < col.length; j++) {
				if (mat[i][j] == 1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (i = 0; i < row.length; i++) {
			for (j = 0; j < col.length; j++) {
				if (row[i] == 1 || col[j] == 1) {
					mat[i][j] = 1;
				}
			}
		}
	}

	public static void printMatrix(Integer mat[][]) {
		int i, j;
		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[0].length; j++) {
				System.out.printf("%d ", mat[i][j]);
			}
			System.out.printf("\n");
		}
	}

	public static void main(String[] args) {
		Integer mat[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, };
		System.out.println("Input Matrix");
		printMatrix(mat);
		modifyMatrix(mat);
		System.out.println("Matrix after modification ");
		printMatrix(mat);
	}
}
