package com.selfPractice.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStringsZ {
	public static final int ALPHA = 26;

	private static String getDiffString(String str) {
		String shift = "";
		for (int i = 1; i < str.length(); i++) {
			int dif = str.charAt(i) - str.charAt(i - 1);
			if (dif < 0)
				dif += ALPHA;

			// Representing the difference as char
			shift += (dif + 'a');
		}

		// This string will be 1 less length than str
		return shift;
	}

	// Method for grouping shifted string
	private static void groupShiftedString(String str[], int n) {
		// map for storing indices of string which are
		// in same group
		Map<String, List<String>> groupMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String diffStr = getDiffString(str[i]);

			if (groupMap.get(diffStr) == null) {
				List<String> group = new ArrayList<>();
				group.add(str[i]);
				groupMap.put(diffStr, group);
			} else {
				groupMap.get(diffStr).add(str[i]);
			}
		}

		for (Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
			List<String> list = entry.getValue();
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	// Driver method to test above methods
	public static void main(String[] args) {
		String[] str = { "acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs", "bafg"};
		int n = str.length;
		groupShiftedString(str, n);
	}
}
