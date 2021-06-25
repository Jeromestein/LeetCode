import java.util.ArrayList;

/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
    // leftSum: the sum of i's left
    int[] nums, leftSum;
    int sum;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.leftSum = new int[nums.length];

        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
            sum += nums[i];

            if (i == 0) {
                leftSum[i] = 0;
            } else {
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
            }
        }

    }

    public int sumRange(int left, int right) {
        if (right == nums.length - 1) {
            return sum - leftSum[left];
        } else {
            return leftSum[right + 1] - leftSum[left];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(left,right);
 */
// @lc code=end
