package com.selfPractice.Matrix;

public class SortedMatrixKthSmallest {
	
	public static int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;

		int lower = matrix[0][0];
		int upper = matrix[m - 1][m - 1];

 		while (lower < upper) {
			int mid = lower + ((upper - lower) >> 1);
			int count = count(matrix, mid);
			if (count < k) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}

		return upper;
	}

	private static int count(int[][] matrix, int target) {
		int m = matrix.length;
		int i = m - 1;
		int j = 0;
		int count = 0;

		while (i >= 0 && j < m) {
			if (matrix[i][j] <= target) {
				count += i + 1;
				j++;
			} else {
				i--;
			}
		}

		return count;
	}
	
	public static void main(String[] args) {
		int[][] matrix = { 
							{10, 20, 30, 40},
							{15, 25, 35, 45},
							{27, 29, 37, 48},
							{32, 33, 39, 50},
						};
		
		System.out.println(kthSmallest(matrix, 5));
	}
}
