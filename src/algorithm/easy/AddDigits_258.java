package algorithm.easy;

/**
 * Problem:
 * https://leetcode.com/problems/add-digits/
 *
 * Analysis:
 *
 * Solution1:
 * Add these digits step by step until there's only one digit left.
 *
 * Solution2:
 * The result is one digit, so it can be only range from 0 to 9.
 * Observe the result of these num values:
 * num-> result
 * 0  -> 0
 * 1  -> 1
 * 2  -> 2
 * 3  -> 3
 * 4  -> 4
 * 5  -> 5
 * 6  -> 6
 * 7  -> 7
 * 8  -> 8
 * 9  -> 9
 * 10 -> 1
 * 11 -> 2
 * 12 -> 3
 * 13 -> 4
 * 14 -> 5
 * 15 -> 6
 * 16 -> 7
 * 17 -> 8
 * 18 -> 9
 * 19 -> 1
 * 20 -> 2
 * 21 -> 3
 * 22 -> 4
 * 23 -> 5
 * 24 -> 6
 * 25 -> 7
 * 26 -> 8
 * 27 -> 9
 * 28 -> 1
 * ...
 * ...
 * There's a pattern:
 * result = (num-1)%9+1
 */
public class AddDigits_258 {
    public int addDigits_solution1(int num) {
        if ((num/10) == 0) {
            return num;
        } else {
            int digitsSum = 0;
            while ((num/10) != 0) {
                int digit = (num % 10);
                digitsSum += digit;
                num = ((num-digit) / 10);
            }
            digitsSum += num;
            return addDigits_solution1(digitsSum);
        }
    }

    public int addDigits_solution2(int num) {
        return ((num-1) % 9) + 1;
    }
}
