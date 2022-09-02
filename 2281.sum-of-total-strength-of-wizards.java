import java.util.Stack;

/*
 * @lc app=leetcode id=2281 lang=java
 *
 * [2281] Sum of Total Strength of Wizards
 */

// @lc code=start
class Solution {
    // 1. for each strength[i], find the range,[L, R] that
    // in this range, strength[i] is the weakest strength
    // 2. get the sum of sums of all the subarry, total
    // Sum = preSum[r+1] - preSum[l] (r: i->R; l:L->i)
    // Sum =
    // (i-L+1)(preSumSum[R+2]-preSumSum[i+1])-(R-i+1)(preSumSum[i+1]-preSumSum[L])
    // 3. res += strength[i]*
    public int totalStrength(int[] strength) {
        int mod = (int) 1e9 + 7;
        int len = strength.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        // get left[i] and right[i] for each strength[i]
        // left[i] is the left closest index of element, e < strength[i]
        // right[i] is the right closest index of element, e <= strength[i]
        // right[i] is <= instead of < so that we can avoid double counting equal
        // elements
        for (int i = 0; i < len; i++) {
            while (st.size() > 1 && strength[st.peek()] >= strength[i])
                right[st.pop()] = i;
            left[i] = st.peek();
            st.push(i);
        }

        long preSum = 0L;
        int[] preSumSum = new int[len + 2];
        for (int i = 1; i <= len; ++i) {
            preSum += strength[i - 1];
            preSumSum[i + 1] = (int) ((preSumSum[i] + preSum) % mod);
        }

        long res = 0L;
        for (int i = 0; i < len; ++i) {
            // since left[i] is defaultly -1, and right[i] is defaultly n
            int L = left[i] + 1, R = right[i] - 1;

            long totalSubSum = ((long) (i - L + 1) * (preSumSum[R + 2] - preSumSum[i + 1])
                    - (long) (R - i + 1) * (preSumSum[i + 1] - preSumSum[L])) % mod;
            res = (res + strength[i] * totalSubSum) % mod;
        }

        // avoid overflow, negtive number
        // cause 1e9+7 > Interger.Max
        return (int) (res + mod) % mod;
    }
}
// @lc code=end
