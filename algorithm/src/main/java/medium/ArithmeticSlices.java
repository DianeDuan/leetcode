package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 413
 * Link: https://leetcode.com/problems/arithmetic-slices/
 * <p>
 * Analysis:
 * <p>
 * Solution1:
 * Find the all the longest arithmetic sequences and record their lengths.
 * Every longest arithmetic sequence whose length is x has (x - 1)(x - 2) / 2 subsequences.
 * <p>
 * Solution2:
 * Scan the array, use one variable for current found arithmetic sequence's length,
 * and add it to the result.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlicesSolution1(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        List<Integer> sliceMaxLengths = new ArrayList<>();
        int start = 0;
        int difference = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] != difference) {
                if ((i - start) >= 3) {
                    sliceMaxLengths.add(i - start);
                }
                start = i - 1;
                difference = A[i] - A[i - 1];
            } else if (i == (A.length - 1)) {
                sliceMaxLengths.add(i - start + 1);
            }
        }

        int result = 0;
        for (Integer sliceMaxLength : sliceMaxLengths) {
            int curSliceNumber = ((sliceMaxLength - 1) * (sliceMaxLength - 2)) / 2;
            result += curSliceNumber;
        }
        return result;
    }

    public int numberOfArithmeticSlicesSolution2(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int difference = A[1] - A[0];
        int result = 0, curSeqLength = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] != difference) {
                curSeqLength = 0;
                difference = A[i] - A[i - 1];
            } else {
                curSeqLength++;
                result += curSeqLength;
            }
        }
        return result;
    }
}
