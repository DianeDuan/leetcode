package algorithm.hard;

/**
 * Problem:
 * No: 44
 * Link: https://leetcode.com/problems/wildcard-matching/
 * <p/>
 * Analysis:
 * Reference:
 * http://shmilyaw-hotmail-com.iteye.com/blog/2154716
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0, match = 0, starIdx = -1;
        while (sIdx < s.length()) {
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {// advancing both pointers
                sIdx++;
                pIdx++;
            } else if (pIdx < p.length() && p.charAt(pIdx) == '*') { // * found, only advancing pattern pointer
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            } else if (starIdx != -1) {// last pattern pointer was *, advancing string pointer
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            } else {//current pattern pointer is not star, last patter pointer was not *, and characters do not match
                return false;
            }
        }
        //check for remaining characters in pattern
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        return pIdx == p.length();
    }
}
