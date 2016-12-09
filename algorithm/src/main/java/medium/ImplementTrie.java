package algorithm.medium;

import algorithm.vo.TrieNode;

/**
 * Problem:
 * No: 208
 * Link: https://leetcode.com/problems/implement-trie-prefix-tree/
 * <p/>
 * Analysis:
 * Implement a data structure according to trie definition.
 * <p/>
 * Reference:
 * https://en.wikipedia.org/wiki/Trie?oldformat=true
 */
public class ImplementTrie {
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (current.children[pos] == null) {
                TrieNode newNode = new TrieNode(word.charAt(i));
                current.children[pos] = newNode;
                current = newNode;
            } else {
                current = current.children[pos];
            }
            if (i == (word.length() - 1)) {
                current.count++;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return searchCount(word) > 0;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchCount(prefix) >= 0;
    }

    private int searchCount(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (current.children[pos] == null) {
                return -1;
            } else {
                current = current.children[pos];
            }
            if (i == (word.length() - 1)) {
                return current.count;
            }
        }
        return -1;
    }
}
