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

    public void backtrack(int n, int leftCNT, int rightCNT, List<String> res, StringBuilder tempStr) {
        if (rightCNT == leftCNT && rightCNT == n) {
            res.add(tempStr.toString());
            return;
        }

        // two branches:
        // 1. add a left bracket
        if (leftCNT + 1 <= n) {
            // the no. of left bracket should be no greater than n
            tempStr.append('(');
            backtrack(n, leftCNT + 1, rightCNT, res, tempStr);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
        // 2. add a right bracket
        if (rightCNT + 1 <= leftCNT) {
            // the no. of right bracket should be no greater than unpaired left bracket
            tempStr.append(')');
            backtrack(n, leftCNT, rightCNT + 1, res, tempStr);
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
    }
}
// @lc code=end
