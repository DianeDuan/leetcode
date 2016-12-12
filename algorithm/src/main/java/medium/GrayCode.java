package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 89
 * Link: https://leetcode.com/problems/gray-code/
 * <p/>
 * Analysis:
 * The n bits gray code is composed of two parts,
 * the first part is (n-1) bits gray code,
 * the second part is the sums of add 1 at the rightmost position to those (n-1) bits values.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        if (n <= 0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> preGrayCode = grayCode(n - 1);
        int tmp = 1 << (n - 1);
        List<Integer> result = new ArrayList<Integer>(preGrayCode);
        for (int i = (preGrayCode.size() - 1); i > -1; i--) {
            result.add(tmp + preGrayCode.get(i));
        }
        return result;
    }
}
