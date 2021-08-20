import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Deque<Character> ops = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        ops.push('+');
        // s consists of integers and operators ('+', '-', '*', '/') separated by some
        // number of spaces.

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '/' || s.charAt(i) == '*' || s.charAt(i) == '-' || s.charAt(i) == '+') {
                // operator
                ops.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // number
                int currNum = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    currNum *= 10;
                    currNum += s.charAt(i) - '0';
                    i++;
                }

                // delete * and /, only leave + and -
                if (ops.peek() == '*') {
                    int preNum = nums.pop();
                    ops.pop();
                    nums.push(preNum * currNum);
                } else if (ops.peek() == '/') {
                    int preNum = nums.pop();
                    ops.pop();
                    nums.push(preNum / currNum);
                } else {
                    nums.push(currNum);
                }
            }
        }

        int res = 0;
        while (!ops.isEmpty() && !nums.isEmpty()) {
            int currNum = nums.pop();
            int currOp = ops.pop();
            if (currOp == '+') {
                res += currNum;
            } else {
                res -= currNum;
            }
        }

        return res;
    }
}
// @lc code=end
