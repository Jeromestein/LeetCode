import java.util.ArrayList;

/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
    // leftSum: the sum of i's left
    int[] leftSum;

    public NumArray(int[] nums) {
        leftSum = new int[nums.length + 1];

        leftSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum[i + 1] = leftSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return leftSum[right + 1] - leftSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(left,right);
 */
// @lc code=end
