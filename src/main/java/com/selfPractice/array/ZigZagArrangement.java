package com.selfPractice.array;

public class ZigZagArrangement {
	// C++ program to sort an array in Zig-Zag form

	// Program for zig-zag conversion of array
	private static void zigZag(int arr[], int n) {
		// Flag true indicates relation "<" is expected,
		// else ">" is expected. The first expected relation
		// is "<"
		boolean flag = true;

		for (int i = 0; i <= n - 2; i++) {
			if (flag) /* "<" relation expected */
			{
				/*
				 * If we have a situation like A > B > C, we get A > B < C by
				 * swapping B and C
				 */
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else /* ">" relation expected */
			{
				/*
				 * If we have a situation like A < B < C, we get A < C > B by
				 * swapping B and C
				 */
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag; /* flip flag */
		}
	}

	// Driver program
	public static void main(String[] args) {
		int arr[] = { 4, 3, 7, 8, 6, 2, 1 };
		int n = arr.length;
		zigZag(arr, n);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}
