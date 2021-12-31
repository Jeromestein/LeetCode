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
        // s consists of integers and operators ('+', '-', '*', '/')
        // separated by some number of spaces.
        // 1. use stack to process all the * and /,
        // we don't even need an actual stack, only a preNum
        // Stack<Integer> st=new Stack<>();
        int n = s.length();
        int preNum = 0, num = 0, res = 0;
        char preSign = '+';
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                num = num * 10 + curr - '0';
            }
            // two situations:
            // 1. ops sign
            // 2. the last char in string
            if (!Character.isDigit(curr) && curr != ' ' || i == n - 1) {
                if (preSign == '+') {
                    res += preNum;
                    preNum = num;
                } else if (preSign == '-') {
                    res += preNum;
                    preNum = -num;
                } else if (preSign == '*') {
                    preNum *= num;
                } else if (preSign == '/') {
                    preNum /= num;
                }
                preSign = curr;
                num = 0;
            }
        }
        res += preNum;
        return res;
    }
}
// @lc code=end
