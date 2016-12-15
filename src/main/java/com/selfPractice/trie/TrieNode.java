package com.selfPractice.trie;

import java.util.*;

class TrieNode {
	char content;
	boolean isEnd;
	int count;
	LinkedList<TrieNode> childList;

	/* Constructor */
	public TrieNode(char c) {
		childList = new LinkedList<TrieNode>();
		isEnd = false;
		content = c;
		count = 0;
	}

	public TrieNode subNode(char c) {
		if (childList != null)
			for (TrieNode eachChild : childList)
				if (eachChild.content == c)
					return eachChild;
		return null;
	}
}
