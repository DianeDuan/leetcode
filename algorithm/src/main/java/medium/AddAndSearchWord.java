package medium;

import provided.vo.TrieNode;

/**
 * Problem:
 * No: 211
 * Link: https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * <p/>
 * Analysis:
 * Use trie data structure.
 */
public class AddAndSearchWord {
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
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
                current.count = 1;
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int start, TrieNode current) {
        if (word == null || word.length() == 0 || current == null) {
            return false;
        }

        for (int i = start; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < current.children.length; j++) {
                    if (search(word, i + 1, current.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                int pos = word.charAt(i) - 'a';
                if (current.children[pos] == null) {
                    return false;
                } else {
                    current = current.children[pos];
                }
            }
        }
        return current.count == 1;
    }
}
