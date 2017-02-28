package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * No: 500
 * Link: https://leetcode.com/problems/keyboard-row/
 * <p>
 * Analysis:
 * Check if a word's all letters are in the same row.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<List<Character>> rows = getAllRows();
        List<String> sameRowWords = new ArrayList<>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            int rowNo = findRowNo(lowerCaseWord.charAt(0), rows);
            boolean hasDifferentRowChar = false;
            for (int i = 1; i < lowerCaseWord.length(); i++) {
                int curRowNo = findRowNo(lowerCaseWord.charAt(i), rows);
                if (curRowNo != rowNo) {
                    hasDifferentRowChar = true;
                    break;
                }
            }
            if (!hasDifferentRowChar) {
                sameRowWords.add(word);
            }
        }

        String[] result = new String[sameRowWords.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sameRowWords.get(i);
        }
        return result;
    }

    private List<List<Character>> getAllRows() {
        List<List<Character>> rows = new ArrayList<>();

        List<Character> row1 = new ArrayList<>();
        row1.add('q');
        row1.add('w');
        row1.add('e');
        row1.add('r');
        row1.add('t');
        row1.add('y');
        row1.add('u');
        row1.add('i');
        row1.add('o');
        row1.add('p');
        rows.add(row1);

        List<Character> row2 = new ArrayList<>();
        row2.add('a');
        row2.add('s');
        row2.add('d');
        row2.add('f');
        row2.add('g');
        row2.add('h');
        row2.add('j');
        row2.add('k');
        row2.add('l');
        rows.add(row2);

        List<Character> row3 = new ArrayList<>();
        row3.add('z');
        row3.add('x');
        row3.add('c');
        row3.add('v');
        row3.add('b');
        row3.add('n');
        row3.add('m');
        rows.add(row3);

        return rows;
    }

    private int findRowNo(char c, List<List<Character>> rows) {
        for (int i = 0; i < rows.size(); i++) {
            List<Character> characters = rows.get(i);
            if (characters.contains(c)) {
                return i;
            }
        }
        return -1;
    }
}
