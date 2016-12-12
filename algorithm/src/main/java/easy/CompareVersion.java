package easy;

/**
 * Problem:
 * No: 165
 * Link: https://leetcode.com/problems/compare-version-numbers/
 * <p/>
 * Analysis:
 * Parse to integer arrays and then compare them from index 0 to the end.
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        int length = Math.max(version1.length(), version2.length());
        int[] digits1 = getVersionDigits(version1, length);
        int[] digits2 = getVersionDigits(version2, length);
        int i = 0;
        while (i < Math.min(digits1.length, digits2.length)) {
            if (digits1[i] > digits2[i]) {
                return 1;
            } else if (digits1[i] < digits2[i]) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    private int[] getVersionDigits(String version, int length) {
        version = version.replace(".", " ");
        String[] array = version.split(" ");
        int[] digits = new int[length];
        int i = 0;
        while (i < array.length) {
            digits[i] = Integer.parseInt(array[i]);
            i++;
        }
        while (i < length) {
            digits[i] = 0;
            i++;
        }
        return digits;
    }
}
