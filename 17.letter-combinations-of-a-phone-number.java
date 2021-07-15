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
            res.add(new String(tempStr.toString()));
            return;
        }

        // Given a string containing digits from 2-9 inclusive
        int digit = digits.charAt(idx) - '0';
        String str = letters[digit - 2];
        for (int i = 0; i < str.length(); i++) {
            tempStr.append(str.substring(i, i + 1));
            backtrack(digits, idx + 1, res, tempStr);
            tempStr.delete(tempStr.length() - 1, tempStr.length());
        }

    }
}
// @lc code=end
