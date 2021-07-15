import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(n, 0, 0, res, new StringBuilder());
        return res;
    }

    public void backtrack(int n, int unpaired, int paired, List<String> res, StringBuilder tempStr) {
        if (paired == n) {
            res.add(tempStr.toString());
            return;
        }

        // two branches:
        // 1. add a left bracket
        if (unpaired + 1 <= n - paired) {
            // the no. of left bracket should be less than n- paired bracket
            tempStr.append('(');
            backtrack(n, unpaired + 1, paired, res, tempStr);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
        // 2. add a right bracket
        if (paired + 1 <= n && unpaired > 0) {
            // the no. of right bracket should be less than n
            // and no greater than unpaired left bracket
            tempStr.append(')');
            backtrack(n, unpaired - 1, paired + 1, res, tempStr);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
    }
}
// @lc code=end
