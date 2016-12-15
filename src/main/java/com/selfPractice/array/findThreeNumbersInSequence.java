package com.selfPractice.array;

public class findThreeNumbersInSequence {
	public static void main(String[] args) {
		int arr[] = { 5, 7, 4, 8 };
		int n = arr.length;
		find3Numbers(arr, n);
	}

	static void find3Numbers(int[] a, int n) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MAX_VALUE;
		int i = 0;
		for (i = 0; i < n; i++) {
			if (a[i] <= min) {
				min = a[i];
			} else if (a[i] <= max) {
				max = a[i];
			} else {
				break;
			}
		}

		if (i == n) {
			System.out.println("No Triplet Found! ");
			return;
		}

		for (int j = 0; j <= i; j++) {
			if (a[j] < max) {
				min = a[j];
				break;
			}
		}
		
		System.out.println("Small: "+min);
		System.out.println("Large: "+max);
		System.out.println("Largest: "+a[i]);
	}
}
