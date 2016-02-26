package algorithm.medium;

import java.util.Set;

/**
 * Problem:
 * https://leetcode.com/problems/word-break/
 * <p/>
 * Analysis:
 * Dynamic programming solution.
 * Use a dp array to record if the substrings can be broken into words by wordDict.
 * dp[i] means if the substring which starts from the first letter to the (i - 1)th letter can be broken into words.
 * If dp[j] = true (j >= 0 and j <= i) and substring which starts from the jth letter to the ith letter is a word in wordDict,
 * dp[i] can be true.
 * <p/>
 * Reference:
 * http://blog.csdn.net/linhuanmars/article/details/22358863
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
