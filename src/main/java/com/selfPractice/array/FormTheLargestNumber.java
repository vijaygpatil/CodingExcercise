package com.selfPractice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FormTheLargestNumber {
	private static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String xy = o1 + o2;
			String yx = o2 + o1;
			return yx.compareTo(xy);
		}
	}

	static void printLargest(List<String> arr) {
		// Sort the numbers using library sort funtion. The function uses
		// our comparison function myCompare() to compare two strings.
		// See http://www.cplusplus.com/reference/algorithm/sort/ for details
		Collections.sort(arr, new StringComparator());

		for (int i = 0; i < arr.size(); i++)
			System.out.print(arr.get(i));
	}

	public static void main(String[] args) {
		List<String> numbers = new ArrayList<>();
		numbers.add("54");
		numbers.add("546");
		numbers.add("548");
		numbers.add("60");
		printLargest(numbers);
	}
}