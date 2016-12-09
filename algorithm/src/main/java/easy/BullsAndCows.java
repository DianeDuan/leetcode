package algorithm.easy;

/**
 * Problem:
 * No: 299
 * Link: https://leetcode.com/problems/bulls-and-cows/
 * <p/>
 * Analysis:
 * Use a digitCounts array to record the digit's occurrences in guess and secret when it's not a bull.
 * <p/>
 * Reference:
 * http://www.cnblogs.com/grandyang/p/4929139.html
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) {
            return "";
        }

        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        int[] digitCounts = new int[10];
        int bullCount = 0;
        int cowCount = 0;
        for (int i = 0; i < guess.length(); i++) {
            int secretDigit = secretChars[i] - '0';
            int guessDigit = guessChars[i] - '0';
            if (secretDigit == guessDigit) {
                bullCount++;
            } else {
                if (digitCounts[secretDigit] < 0) {
                    cowCount++;
                }
                digitCounts[secretDigit]++;
                if (digitCounts[guessDigit] > 0) {
                    cowCount++;
                }
                digitCounts[guessDigit]--;
            }
        }
        return bullCount + "A" + cowCount + "B";
    }
}
