package easy;

/**
 * Problem:
 * No: 345
 * Link: https://leetcode.com/problems/reverse-vowels-of-a-string
 * <p>
 * Analysis:
 * Scan the string from the start and the end simultaneously,
 * and swap the paris of vowels which are found during the scan.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        int front = 0, rear = chars.length - 1;
        while (front < rear) {
            while (front < chars.length && !isVowel(chars[front])) {
                front++;
            }
            while (rear >= 0 && !isVowel(chars[rear])) {
                rear--;
            }
            if (front < rear) {
                char tmp = chars[front];
                chars[front] = chars[rear];
                chars[rear] = tmp;
                front++;
                rear--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowels) {
            if (vowel == c) {
                return true;
            }
        }
        return false;
    }
}
