package com.selfPractice.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie2 {

	private static final TrieNode[] EMPTYNODES = new TrieNode[0];

	private static final class TrieNode implements Comparable<TrieNode> {

		private final char character;
		private boolean isWord = false;
		private Map<Character, TrieNode> children = null;

		public TrieNode(char ch) {
			character = ch;
		}

		public TrieNode getOrCreateChild(char ch) {
			if (children == null) {
				children = new HashMap<>();
			}
			TrieNode kid = children.get(ch);
			if (kid == null) {
				kid = new TrieNode(ch);
				children.put(ch, kid);
			}
			return kid;
		}

		public TrieNode get(char ch) {
			return children != null ? children.get(ch) : null;
		}

		public void setWord() {
			isWord = true;
		}

		public boolean isWord() {
			return isWord;
		}

		public char getChar() {
			return character;
		}

		public TrieNode[] getChildNodes() {
			if (children == null) {
				return EMPTYNODES;
			}
			TrieNode[] result = children.values().toArray(new TrieNode[children.size()]);
			Arrays.sort(result);
			return result;
		}

		@Override
		public int compareTo(TrieNode o) {
			// cheap way to sort alphabetically.
			return (int) character - o.character;
		}

	}

	private final TrieNode root; // fix - make root final.
	private int size = 0; // how many words
	private int depth = 0; // longest word

	public Trie2() {
		// root has null character.
		root = new TrieNode((char) 0);
	}

	public void addWord(String word) {
		TrieNode node = root;
		int wdepth = 0;
		for (char ch : word.toLowerCase().toCharArray()) {
			node = node.getOrCreateChild(ch);
			wdepth++;
		}
		if (!node.isWord()) { // fix - only add new words....
			node.setWord();
			size++;
			if (wdepth > depth) {
				depth = wdepth;
			}
		}
	}

	public boolean containsWord(String word) {
		TrieNode node = root;
		for (char ch : word.toLowerCase().toCharArray()) {
			node = node.get(ch);
			if (node == null) {
				break;
			}
		}
		return node != null && node.isWord();
	}

	public int size() {
		return size;
	}

	public List<String> getWords() {
		// set up a recursion call.
		List<String> result = new ArrayList<>(size);
		char[] charstack = new char[depth];
		getWords(root, charstack, 0, result);
		return result;
	}

	private void getWords(final TrieNode node, final char[] charstack, final int stackdepth, final List<String> result) {
		if (node == null) {
			return;
		}
		if (node.isWord()) {
			result.add(new String(charstack, 0, stackdepth));
		}
		for (TrieNode kid : node.getChildNodes()) {
			charstack[stackdepth] = kid.getChar();
			getWords(kid, charstack, stackdepth + 1, result);
		}
	}

	public static void main(String[] args) {
		Trie2 t = new Trie2();
		
		String[] wordArr = {"cat", "dog", "tac", "god", "act", "gdo"};
		for(int i = 0; i < wordArr.length; i++) {
			char[] wordchar = wordArr[i].toCharArray();
			Arrays.sort(wordchar);
			String sortedWord = new String(wordchar);
			t.addWord(sortedWord+i);
		}
		
		List<String> words = t.getWords();
		for (String s : words) {
			System.out.println(s);
		}
	}
}
