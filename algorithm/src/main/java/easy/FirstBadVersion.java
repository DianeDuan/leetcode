package easy;

/**
 * Problem:
 * No: 278
 * Link: https://leetcode.com/problems/first-bad-version/
 * <p/>
 * Analysis:
 * Binary search.
 * Use long type for avoiding overflow situation.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(long start, long end) {
        if (start > end) {
            return -1;
        }

        long mid = (start + end) / 2;
        if (isBadVersion((int) mid)) {
            if ((mid != 1 && !isBadVersion((int) (mid - 1))) || mid == 1) {
                return (int) mid;
            } else {
                return binarySearch(start, mid - 1);
            }
        } else {
            return binarySearch(mid + 1, end);
        }
    }

    //this is a mock method
    private boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}
