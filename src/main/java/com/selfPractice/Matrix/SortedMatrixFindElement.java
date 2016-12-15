package com.selfPractice.Matrix;

public class SortedMatrixFindElement {
	public static boolean findElement(int[][] matrix, int n, int x) {
		
		for(int i = 0, j = n-1; i <= n-1 && j >= 0;) {
			if(x == matrix[i][j]) {
				return true;
			} else {
				if(x < matrix[i][j]) {
					j--;
				} else if (x > matrix[i][j]) {
					i++;
 				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = { 
							{10, 20, 30, 40},
							{15, 25, 35, 45},
							{27, 29, 37, 48},
							{32, 33, 39, 50},
						};
		
		System.out.println(findElement(matrix, 4, 2));
	}
}
