package algorithm.vo;

public class TrieNode {
    public char value;
    public int count;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
        value = '#';
    }

    public TrieNode(char value) {
        this.value = value;
    }
}
