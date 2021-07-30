/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start

class Solution {
    public String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }
}

// @lc code=end
