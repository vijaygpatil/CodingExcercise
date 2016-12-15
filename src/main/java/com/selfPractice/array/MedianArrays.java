package com.selfPractice.array;

public class MedianArrays {
	public static void main(String[] args) {
		int ar1[] = { 1, 2, 3, 6 };
		int ar2[] = { 4, 6, 8, 10 };
		int n1 = ar1.length;
		int n2 = ar2.length;
		if (n1 == n2) {
			System.out.println("Median is: " + getMedian(ar1, ar2, n1));
		} else {
			System.out.println("Doesn't work for arrays of unequal size");
		}
	}

	private static int getMedian(int[] ar1, int[] ar2, int n) {
		if (n <= 0)
			return -1;

		if (n == 1)
			return (ar1[0] + ar2[0]) / 2;

		if (n == 2)
			return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;

		int m1 = median(ar1, n); /* get the median of the first array */
		int m2 = median(ar2, n); /* get the median of the second array */

		if (m1 == m2)
			return m1;

		if (m1 < m2) {
			if (n % 2 == 0) {
				int[] rightEvenArr = new int[n / 2 - 1];
				int j = 0;
				for (int k = n / 2 - 1; k < n - 1; k--) {
					rightEvenArr[j++] = ar1[k];
				}
				return getMedian(rightEvenArr, ar2, n - n / 2 + 1);
			} else {
				int[] rightOddArr = new int[n / 2];
				int j = 0;
				for (int k = n / 2; k < n - 1; k--) {
					rightOddArr[j++] = ar1[k];
				}
				return getMedian(rightOddArr, ar2, n - n / 2);
			}
		} else {
			if (n % 2 == 0) {
				int[] rightEvenArr = new int[n / 2 - 1];
				int j = 0;
				for (int k = n / 2 - 1; k < n - 1; k--) {
					rightEvenArr[j++] = ar2[k];
				}
				return getMedian(rightEvenArr, ar1, n - n / 2 + 1);
			} else {
				int[] rightOddArr = new int[n / 2];
				int j = 0;
				for (int k = n / 2; k < n - 1; k--) {
					rightOddArr[j++] = ar2[k];
				}
				return getMedian(rightOddArr, ar1, n - n / 2);
			}
		}
	}

	private static int median(int[] arr, int n) {
		if (n % 2 == 0)
			return (arr[n / 2] + arr[n / 2 - 1]) / 2;
		else
			return arr[n / 2];
	}
}
