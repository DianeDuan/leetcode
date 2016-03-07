package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/unique-binary-search-trees/
 * <p/>
 * Analysis:
 * In a binary search tree, if the root node is i,
 * the left subtree root must be in [1, i-1],
 * the right subtree root must be in [i+1, n].
 * Use a count array to record the counts of unique binary trees,
 * count[i] equals to the count of unique binary trees which store 1, 2, ..., i.
 * <p/>
 * Reference:
 * http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
 * https://siddontang.gitbooks.io/leetcode-solution/content/dynamic_programming/unique_binary_search_trees.html
 */
public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            count[i] = 0;
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
