package com.selfPractice.array;

public class LeftOrRightPositionedArray {
	public static void main(String[] args) {
		int arr[] = { 2, 1, 5, 2, 1, 5 };
		int n = arr.length;

		if (leftRight(arr, n) == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static boolean leftRight(int[] arr, int n) {
		// Initially no element is placed at any position
		int[] visited = new int[n];
		for (int i = 0; i < n; i++) {
			visited[i] = 0;
		}

		// Traverse each element of array
		for (int i = 0; i < n; i++) {
			// Element must be smaller than n.
			if (arr[i] < n) {
				// Place "arr[i]" at position "i"
				// or at position n-arr[i]-1
				if (visited[arr[i]] == 0)
					visited[arr[i]] = 1;
				else
					visited[n - arr[i] - 1] = 1;
			}
		}

		// All positions must be occupied
		for (int i = 0; i < n; i++)
			if (visited[i] == 0)
				return false;

		return true;
	}
}
