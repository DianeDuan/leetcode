package medium;

/**
 * Problem:
 * No: 318
 * Link: https://leetcode.com/problems/maximum-product-of-word-lengths/
 * <p/>
 * Analysis:
 * Calculate the products of every pair of words which doesn't share any common letter to find the maximum product.
 * To judge whether the two strings share common letters, use a int to record the letters appeared in a string.
 * The record method is:
 * If 'a' is in the string, set the first bit of the int 1,
 * if 'b' is in the string, set the second bit of the int 1,
 * and so on.
 * As a int has 32 bits and there are only 26 English characters, the space is enough.
 * If the and operation result of the two integers which record the letters for a pair of string is 0,
 * that means there is no common letter in these two strings.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null) {
            return 0;
        }
        int maxProduct = 0;
        int[] mask = getWordsMask(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = (i + 1); j < words.length; j++) {
                if ((mask[i] & mask[j]) != 0) {//words[i] and words[j] share at least one common letter
                    continue;
                }
                int product = words[i].length() * words[j].length();
                if (maxProduct < product) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    private int[] getWordsMask(String[] words) {
        if (words == null || words.length == 0) {
            return new int[0];
        }
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                mask[i] |= (1 << ch - 'a');
            }
        }
        return mask;
    }
}
