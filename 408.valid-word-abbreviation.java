/*
 * @lc app=leetcode id=408 lang=java
 *
 * [408] Valid Word Abbreviation
 */

// @lc code=start

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        // 1. 2 pointers, walk through word and abbr at the same time
        // 2. getNum() in abbr, and check if it is right (no leading zero, no empty)
        // 3. return

        int len1 = word.length(), len2 = abbr.length();
        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < len1 && ptr2 < len2) {
            if (Character.isDigit(abbr.charAt(ptr2))) {
                // no leading zeros, no empty
                if (abbr.charAt(ptr2) == '0')
                    return false;
                // get num, from the substring
                int start = ptr2;
                while (ptr2 < len2 && Character.isDigit(abbr.charAt(ptr2))) {
                    ptr2++;
                }
                ptr1 += Integer.valueOf(abbr.substring(start, ptr2));

            } else {
                if (word.charAt(ptr1) != abbr.charAt(ptr2)) {
                    return false;
                } else {
                    ptr1++;
                    ptr2++;
                }
            }

        }

        return ptr1 == len1 && ptr2 == len2;
    }
}
// @lc code=end
