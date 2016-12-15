package com.selfPractice.String;

public class StringCombinations {
	char[] array;
	boolean[] visited;
	String text = "abc";

	public static void main(String[] args) {
		StringCombinations st = new StringCombinations();
		st.printCombination("");
	}

	public StringCombinations() {
		array = this.text.toCharArray();
		visited = new boolean[array.length];
	}

	public void printCombination(String val) {
		if (val != null && val.length() >= 0) {
			System.out.println(val);
		}

		for (int x = 0; x < text.length(); x++) {
			if (visited[x] == false) {
				visited[x] = true;
				String val2 = text.charAt(x) + "";
				printCombination(val + val2);
				visited[x] = false;
			}
		}
	}
}
