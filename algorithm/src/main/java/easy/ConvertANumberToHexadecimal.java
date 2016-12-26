package easy;

/**
 * Problem:
 * No: 405
 * Link: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * <p>
 * Analysis:
 * Every four bits compose a hexadecimal number.
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        char[] hexadecimalNum = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] result = new char[8];
        int firstNotZeroIdx = 7;
        for (int i = 7; i >= 0; i--) {
            int cur = num & 15;
            if (cur != 0) {
                firstNotZeroIdx = i;
            }
            result[i] = hexadecimalNum[cur];
            num >>= 4;
        }

        return String.valueOf(result, firstNotZeroIdx, 8 - firstNotZeroIdx);
    }
}
