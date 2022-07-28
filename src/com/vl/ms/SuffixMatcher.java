package com.vl.ms;

import java.util.ArrayDeque;
import java.util.Deque;

import com.vl.ms.Trie.TrieNode;

public class SuffixMatcher {
	private Trie trie;

	public SuffixMatcher() {
		this.trie = new Trie();
	}

	public void addSuffix(String suffix) {
		this.trie.insert(suffix);
	}

	public Result match(String text) {
		Deque<Character> deque = new ArrayDeque<>();
		Result res = new Result();
		TrieNode prev = null;
		TrieNode curr = this.trie.getRoot();
		for (int i = text.length() - 1; i > -1; i--) {
			char c = text.charAt(i);
			if (curr.getChildren().containsKey(c)) {
				deque.addFirst(c);
				prev = curr;
				curr = curr.getChildren().get(c);
			} else {
				if (curr.isEndOfWord()) {
					StringBuilder sb = new StringBuilder(deque.size());
					for (char character : deque) {
						sb.append(character);
					}
					res.setContent(text.substring(0, text.length() - deque.size()));
					res.setSuffix(sb.toString());
				} else {
					prev = null;
				}
				break;
			}
		}

		if (prev == null) {
			res.setContent(text);
			res.setSuffix("");
		}

		return res;
	}
}
