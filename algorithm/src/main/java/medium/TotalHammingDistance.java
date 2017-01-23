package medium;

/**
 * Problem:
 * No: 477
 * Link: https://leetcode.com/problems/total-hamming-distance/
 * <p>
 * Analysis:
 * For the same position of all the elements,
 * multiply the count of zero bit and the count of one bit to get the hamming distance from that position.
 * The sum of all the distances of all the positions is the total hamming distance.
 * <p>
 * Reference:
 * http://www.cnblogs.com/EdwardLiu/p/6196705.html
 */
public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int oneBitCount = 0;
            for (int num : nums) {
                oneBitCount += (num >> i & 1);
            }
            result += oneBitCount * (nums.length - oneBitCount);
        }
        return result;
    }
}
