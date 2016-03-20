package algorithm.medium;

/**
 * Problem:
 * No: 134
 * Link: https://leetcode.com/problems/gas-station/
 * <p/>
 * Analysis:
 * Use variable sum to record if start from current index can reach next gas station.
 * Use variable total to record if the circuit can be completed.
 * <p/>
 * Reference:
 * https://leetcodenotes.wordpress.com/2013/11/21/leetcode-gas-station-%E8%BD%AC%E5%9C%88%E7%9A%84%E5%8A%A0%E6%B2%B9%E7%AB%99%E7%9C%8B%E8%83%BD%E4%B8%8D%E8%83%BD%E8%B5%B0%E4%B8%80%E5%9C%88/
 * http://www.cnblogs.com/springfor/p/3888036.html
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }

        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }
}
