/*
 * @lc app=leetcode id=1762 lang=java
 *
 * [1762] Buildings With an Ocean View
 */

// @lc code=start

class Solution {
    public int[] findBuildings(int[] heights) {
        // 1. tuition: stack, bigger than peek then pop
        // stack save the index
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                st.pop();
            }
            st.push(i);
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}

// @lc code=end
