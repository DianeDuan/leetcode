package provided;

public class GuessGame {
    int target = 1702766719;

    /**
     * fake guess API, leetcode provides real API for submit
     *
     * @param num your guess
     * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     */
    public int guess(int num) {
        if (num == target) {
            return 0;
        } else if (num > target) {
            return -1;
        } else {
            return 1;
        }
    }
}
