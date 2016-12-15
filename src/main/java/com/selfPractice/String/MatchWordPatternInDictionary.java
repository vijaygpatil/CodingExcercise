package com.selfPractice.String;

import java.util.HashMap;

class MatchWordPatternInDictionary {
	public static void main(String[] args) {
		String[] dict = { "abb", "abc", "xyz", "xyy" };
		String pattern = "mnn";
		findMatchedWords(dict, pattern);
	}

	public static void findMatchedWords(String[] dict, String pattern) {
		String hash = encodeString(pattern);
		System.out.println("Pattern HASH: " + hash);

		for (String entry : dict) {
			if (encodeString(entry).equals(hash)) {
				System.out.println(entry);
			}
		}
	}

	public static String encodeString(String pattern) {

		HashMap<Character, Integer> map = new HashMap<>();
		StringBuilder hash = new StringBuilder();
		int i = 0;
		for (char c : pattern.toCharArray()) {
			if (map.get(c) != null) {
				hash.append(map.get(c));
			} else {
				hash.append(++i);
				map.put(c, i);
			}
		}
		return hash.toString();
	}
}
