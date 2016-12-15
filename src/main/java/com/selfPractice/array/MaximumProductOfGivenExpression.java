package com.selfPractice.array;

public class MaximumProductOfGivenExpression {
	public static void main(String[] args) {
		int[] arr = { 8, 1, 9, 4 };
		int n = arr.length;
		System.out.println(Maximum_Product(arr, n));
	}

	static int Maximum_Product(int[] arr, int n) {

		int maxProduct = Integer.MIN_VALUE; // Initialize result
		int currProduct; // product of current pair

		// loop until they meet with each other
		int Left = 0, right = n - 1;
		while (Left < right) {
			if (arr[Left] < arr[right]) {
				currProduct = arr[Left] * (right - Left);
				Left++;
			} else // arr[right] is smaller
			{
				currProduct = arr[right] * (right - Left);
				right--;
			}

			// maximizing the product
			maxProduct = Math.max(maxProduct, currProduct);
		}

		return maxProduct;
	}
}
