/*
 * @lc app=leetcode id=2007 lang=java
 *
 * [2007] Find Original Array From Doubled Array
 */

// @lc code=start
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1)
            return new int[0];
        // use a integer array to count
        int max = 0;
        for (int n : changed) {
            max = Math.max(max, n);
        }

        // to pass [3,3,3,3] situation,
        // max/2 is smaller than all the elements
        int[] cnt = new int[2 * max + 1];
        for (int n : changed) {
            cnt[n]++;
        }

        int[] original = new int[changed.length / 2];
        int idx = 0;
        for (int i = 0; i <= max; i++) {
            if (cnt[i] > 0) {
                cnt[i]--;

                if (cnt[i * 2] > 0) {
                    cnt[i * 2]--;
                    original[idx++] = i;
                    // try 2 times, to pass [1,2,4,2,4,8] situation
                    i--;
                } else {
                    return new int[0];
                }

            }
        }

        return original;
    }
}
// @lc code=end
