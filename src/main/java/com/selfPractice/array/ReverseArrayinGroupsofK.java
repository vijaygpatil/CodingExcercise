package com.selfPractice.array;

public class ReverseArrayinGroupsofK {

	void reverseInKIntervals(int arr[], int n, int k) {
		// increment i in multiples of 2*k
		for (int i = 0; i < n; i += 2 * k) {
			int left = i;

			// to handle case when 2*k is not multiple of n
			int right = Math.min(i + k - 1, n - 1);

			// reverse the sub-array [left, right]
			while (left < right) {
				int t = arr[left++];
				arr[left++] = arr[right--];
				arr[right--] = t;
			}
		}
	}

	static void reverseKplusMInterval(int arr[], int n, int k, int m) {
		// increment i in multiples of k + m
		for (int i = 0; i < n; i += k + m) {
			int left = i;

			// to handle case when k + m is not multiple of n
			int right = Math.min(i + k - 1, n - 1);

			// reverse the sub-array [left, right]
			while (left < right) {
				int t = arr[left++];
				arr[left++] = arr[right--];
				arr[right--] = t;
			}
		}
		System.out.println();
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	static void reversekGroupDoubles(int arr[], int n, int k) {
		// increment i in multiples of k where value
		// of k is doubled with each iteration
		for (int i = 0; i < n; i += k / 2) {
			int left = i;

			// to handle case when number of elements in
			// last group is less than k
			int right = Math.min(i + k - 1, n - 1);

			// reverse the sub-array [left, right]
			while (left < right) {
				int t = arr[left++];
				arr[left++] = arr[right--];
				arr[right--] = t;
			}

			// double value of k with each iteration
			k = k * 2;
		}
		System.out.println();
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int k = 1;
		int n = arr.length;
		reversekGroupDoubles(arr, n, k);

		int arr2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		k = 3;
		int m = 2;
		n = arr2.length;
		reverseKplusMInterval(arr2, n, k, m);
	}
}
