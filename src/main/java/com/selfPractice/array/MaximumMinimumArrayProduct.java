package com.selfPractice.array;

public class MaximumMinimumArrayProduct {
	public static void main(String[] args) {
		int arr[] = { -4, -2, 3, 7, 5, 0, 1 };
		int n = arr.length;
		printMaxAndMinProduct(arr, n);
	}

	static void printMaxAndMinProduct(int[] a, int n) {

		int currentMaxProduct = a[0];
		int currentMinProduct = a[0];
		int previousMaxProduct = a[0];
		int previousMinProduct = a[0];
		int maxProduct = a[0];
		int minProduct = a[0];

		for (int i = 1; i < n; i++) {
			currentMaxProduct = Math.max(previousMaxProduct * a[i], Math.max(previousMaxProduct * a[i], a[i]));
			currentMaxProduct = Math.max(currentMaxProduct, previousMaxProduct);

			currentMinProduct = Math.min(previousMaxProduct * a[i], Math.min(previousMinProduct * a[i], a[i]));
			currentMinProduct = Math.min(currentMinProduct, previousMinProduct);
			
			maxProduct = Math.max(maxProduct, currentMaxProduct);
			minProduct = Math.min(minProduct, currentMinProduct);

			previousMaxProduct = currentMaxProduct;
			previousMinProduct = currentMinProduct;
		}

		System.out.println("Minimum product is: " + minProduct + " Maximum product is: " + maxProduct);
	}
}
