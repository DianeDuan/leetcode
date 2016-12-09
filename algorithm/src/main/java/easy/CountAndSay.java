package algorithm.easy;

/**
 * Problem:
 * No: 38
 * Link: https://leetcode.com/problems/count-and-say/
 * <p/>
 * Analysis:
 * Get first say string to nth say string step by step.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String currentStr = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char previousChar = currentStr.charAt(0);
            for (int j = 1; j < currentStr.length(); j++) {
                if (currentStr.charAt(j) == previousChar) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(previousChar);
                    count = 1;
                    previousChar = currentStr.charAt(j);
                }
            }
            sb.append(count);
            sb.append(previousChar);
            currentStr = sb.toString();
        }
        return currentStr;
    }
}
