/*
 * @lc app=leetcode id=899 lang=java
 *
 * [899] Orderly Queue
 */

// @lc code=start

class Solution {
    public String orderlyQueue(String S, int K) {
        if (K == 1) {
            // if k==1, then we can consider this queue as a loop.
            // all we need to do is to find the sexicographically smallest string from the
            // loop.
            String ans = S;
            for (int i = 0; i < S.length(); ++i) {
                // T is a the string starting from i
                String T = S.substring(i) + S.substring(0, i);
                if (T.compareTo(ans) < 0)
                    ans = T;
            }
            return ans;
        } else {
            // if k>1, then we can swap any two letters in the queue.
            // so just sort it.
            char[] charArray = S.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }
    }
}

// @lc code=end
