package algorithm.medium;

/**
 * Problem:
 * No: 319
 * Link: https://leetcode.com/problems/bulb-switcher/
 * <p/>
 * Analysis:
 * Except square numbers, other integers will be switch even times,
 * because if the number k = a * b, and a != b, there must be k = b * a,
 * that means the bulk no.k will be switched in the a round and the b round,
 * that makes only square numbers will be switched odd times.
 * In the end, only the bulks in square numbers position will be on.
 * That changes this problem to find how many square numbers are there in the range of 1 to n.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        if (n <= 0) {
            return 0;
        }
        return (int) Math.sqrt(n);
    }
}
