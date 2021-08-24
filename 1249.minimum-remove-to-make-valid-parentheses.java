import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Character> stk = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        // walk though string s, remove extra ), if there are
        for (int i = 0; i < s.length(); i++) {
            char currDigit = s.charAt(i);
            res.append(currDigit);

            if (currDigit == '(') {
                stk.addLast(currDigit);
            }
            if (currDigit == ')') {
                if (!stk.isEmpty() && stk.peekLast() == '(') {
                    stk.removeLast();
                } else if (stk.isEmpty()) {
                    // remove current digit, aka the ')'
                    res.deleteCharAt(res.length() - 1);
                }
            }
        }

        // double check stack, remove extra (, if there are
        while (!stk.isEmpty()) {
            int index = res.lastIndexOf("(");
            res.deleteCharAt(index);
            stk.removeLast();
        }

        return res.toString();
    }
}
// @lc code=end
