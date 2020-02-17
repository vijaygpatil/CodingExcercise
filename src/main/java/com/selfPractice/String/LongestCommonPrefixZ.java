package com.selfPractice.String;

public class LongestCommonPrefixZ {

	public static void main(String[] args) {
		String[] arr = { "geeksforgeeks", "geeks", "geek", "geezer" };
		int n = arr.length;

		String ans = commonPrefix(arr, n);

		if (ans.length() > 0) {
			System.out.println("The longest common prefix is: " + ans);
		} else {
			System.out.println("There is no longest common prefix.");
		}
	}

	static String commonPrefix(String[] arr, int n) {
		String res = "";

		int index = findMinLength(arr, n);

		int low = 0, high = index;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (allContainsPrefix(arr, n, arr[0], low, mid)) {
				res = res + arr[0].substring(low, mid - low + 1);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return res;
	}

	static boolean allContainsPrefix(String[] arr, int n, String str, int start, int end) {
		for (int i = 0; i <= n - 1; i++) {
			for (int j = start; j <= end; j++) {
				if (arr[i].charAt(j) != str.charAt(j))
					return (false);
			}
		}
		return (true);
	}

	static int findMinLength(String arr[], int n) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= n - 1; i++) {
			if (arr[i].length() < min) {
				min = arr[i].length();
			}
		}

		return (min);
	}
}