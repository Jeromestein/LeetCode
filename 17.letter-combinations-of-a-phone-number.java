import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (!digits.equals("")) {
            backtrack(digits, 0, res, new StringBuilder());
        }
        return res;
    }

    public void backtrack(String digits, int idx, List<String> res, StringBuilder tempStr) {
        if (idx == digits.length()) {
            res.add(tempStr.toString());
            return;
        }

        // Given a string containing digits from 2-9 inclusive
        int digit = digits.charAt(idx) - '0';
        String str = letters[digit - 2];
        int strLen = letters[digit - 2].length();
        for (int i = 0; i < strLen; i++) {
            tempStr.append(str.charAt(i));
            backtrack(digits, idx + 1, res, tempStr);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }

    }
}
// @lc code=end
