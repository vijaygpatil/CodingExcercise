package com.selfPractice.array;

import java.util.Arrays;

public class MinimizeMaxDifference {
	public static void main(String[] args) {
		int arr[] = { 1, 15, 10 };
		int n = arr.length;
		int k = 6;
		int res = getMinDiff(arr, n, k);
		System.out.println("Minium Max Difference: " + res);
	}

	public static int getMinDiff(int[] a, int n, int k) {
		if (n < 2) {
			return 0;
		}

		Arrays.sort(a);

		int new_min = a[0];
		int new_max = a[n - 1];

		if (k >= new_max - new_min) {
			for (int i = 0; i < n; i++) {
				a[i] = a[i] + k;
			}
			return a[n - 1] - a[0];
		}

		a[0] = a[0] + k;
		a[n - 1] = a[n - 1] - k;

		int max = Math.max(a[0], a[n - 1]);
		int min = Math.min(a[0], a[n - 1]);

		for (int i = 1; i < n - 1; i++) {
			if (a[i] < min) {
				a[i] = a[i] + k;
			} else if (a[i] > max) {
				a[i] = a[i] - k;
			} else if ((a[i] - min) > (max - a[i])) {
				a[i] = a[i] - k;
			} else {
				a[i] = a[i] + k;
			}
			max = Math.max(a[i], max);
			min = Math.min(a[i], min);
		}

		return max - min;
	}
}
