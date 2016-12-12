package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 412
 * Link: https://leetcode.com/problems/fizz-buzz/
 * <p>
 * Analysis:
 * Use modulo operation to determine if a number is multiple of 3, or a multiple of 5, of a multiple of both 3 and 5.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int mod3 = i % 3;
            int mod5 = i % 5;
            if (mod3 == 0 && mod5 == 0) {
                result.add("FizzBuzz");
            } else if (mod3 == 0) {
                result.add("Fizz");
            } else if (mod5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}