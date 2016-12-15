package com.selfPractice.array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairsInArraySumEqualsK {
	
	public static void printPairs(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			int first = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int second = array[j];
				if ((first + second) == sum) {
					System.out.printf("(%d, %d) %n", first, second);
				}
			}
		}
	}

	public static void printPairsUsingSet(int[] numbers, int n) {
		if (numbers.length < 2) {
			return;
		}
		Set<Integer> set = new HashSet<>(numbers.length);
		for (int value : numbers) {
			int target = n - value;
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}
	
	public static void printPairsUsingTwoPointers(int[] numbers, int k) {
		if (numbers.length < 2) {
			return;
		}
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				left = left + 1;
				right = right - 1;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right - 1;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
		int k = 11;
		printPairs(a, k);
		printPairsUsingSet(a, k);
		printPairsUsingTwoPointers(a, k);
	}
}
