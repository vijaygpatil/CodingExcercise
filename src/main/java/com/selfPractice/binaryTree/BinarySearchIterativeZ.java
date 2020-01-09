package com.selfPractice.binaryTree;

import java.util.Arrays;
import java.util.List;

public class BinarySearchIterativeZ {

	public static int searchFirstOfK(List<Integer> A, int k) {
		int left = 0;
		int right = A.size() - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (A.get(mid) > k) {
				right = mid - 1;
			} else if (A.get(mid) == k) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
		System.out.println(searchFirstOfK(A, 9));
		System.out.println(searchFirstOfK(A, 4));
	}
}