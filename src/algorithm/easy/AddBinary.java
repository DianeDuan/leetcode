package algorithm.easy;

/**
 * Problem:
 * No: 67
 * Link: https://leetcode.com/problems/add-binary/
 * <p/>
 * Analysis:
 * Change a and b into arrays whose lengths are the max of a's and b's length.
 * Add those two arrays to get result.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }

        int length = Math.max(a.length(), b.length());
        byte[] bitsA = getBits(a, length);
        byte[] bitsB = getBits(b, length);
        byte[] result = new byte[length + 1];
        byte carry = 0;
        int i = 0;
        while (i < length) {
            byte tmp = (byte) (bitsA[i] + bitsB[i] + carry);
            result[i] = (byte) (tmp % 2);
            carry = (byte) (tmp / 2);
            i++;
        }
        result[i] = carry;
        return parseToStr(result);
    }

    private byte[] getBits(String s, int length) {
        if (s == null || length < s.length()) {
            return null;
        }

        byte[] bits = new byte[length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            bits[i] = (byte) (chars[chars.length - i - 1] - '0');
        }
        return bits;
    }

    private String parseToStr(byte[] bits) {
        StringBuilder sb = new StringBuilder();
        for (int i = (bits.length - 1); i > -1; i--) {
            if (bits[i] == 0 && sb.length() == 0) {//omit highest zeroes
                continue;
            }
            sb.append(bits[i]);
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}
