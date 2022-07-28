package com.vl.ms;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}

	public static class TrieNode {
		private Map<Character, TrieNode> children;
		private boolean endOfWord;

		public TrieNode() {
			this.children = new HashMap<>();
		}

		public Map<Character, TrieNode> getChildren() {
			return children;
		}

		public void setChildren(Map<Character, TrieNode> children) {
			this.children = children;
		}

		public boolean isEndOfWord() {
			return endOfWord;
		}

		public void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
	}

	public void insert(String word) {
		TrieNode curr = root;

		for (int i = word.length() - 1; i > -1; i--) {
			char c = word.charAt(i);
			curr = curr.getChildren().computeIfAbsent(c, ch -> new TrieNode());
		}

		curr.setEndOfWord(true);
	}
}
