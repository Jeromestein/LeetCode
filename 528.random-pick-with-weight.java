import java.util.Arrays;

/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    int[] prefix;
    int n;

    public int binarySearch(int target) {
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > prefix[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }

    public Solution(int[] w) {
        this.n = w.length;
        this.prefix = new int[n];

        this.prefix[0] = w[0];
        for (int i = 1; i < n; i++)
            prefix[i] = w[i] + prefix[i - 1];
    }

    public int pickIndex() {
        int roll = ((int) (Math.random() * prefix[n - 1])) + 1;
        return binarySearch(roll);

        // // index of the search key, if it is contained in the array;
        // // otherwise, (-(insertion point) - 1).
        // int resindex = Arrays.binarySearch(prefix, roll);
        // int res = resindex >= 0 ? resindex : (resindex + 1) * -1;
        // return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */
// @lc code=end
