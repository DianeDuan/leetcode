package easy;

import java.util.Arrays;

/**
 * Problem:
 * No: 383
 * Link: https://leetcode.com/problems/ransom-note/
 * <p>
 * Analysis:
 * Sort the chars of  both ransomNote and magazine,
 * and then compare from the first letter to the last letter of the ransomNote chars.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();

        Arrays.sort(ransomNoteChars);
        Arrays.sort(magazineChars);

        int i = 0, j = 0;
        while (i < ransomNoteChars.length) {
            if (j == magazineChars.length) {
                break;
            }

            if (ransomNoteChars[i] == magazineChars[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return (i == ransomNoteChars.length);
    }
}
