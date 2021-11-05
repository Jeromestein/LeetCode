/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start

class Solution {
    public int maximumSwap(int num) {
        // 1. record the last position digit[0-9] in num
        // 2. walk through num from left to right, check whether there exists a larger
        // digit in // this num (start from 9 to current digit) behind the current one.
        // 3. swap

        // 12314142,
        char[] nums = Integer.toString(num).toCharArray();
        int n = nums.length;
        int[] digits = new int[10];
        for (int i = 0; i < n; i++) {
            digits[nums[i] - '0'] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int k = 9; k > nums[i] - '0'; k--) {
                if (digits[k] > i) {
                    swap(nums, i, digits[k]);
                    return Integer.valueOf(String.valueOf(nums));
                }
            }
        }

        return num;

    }

    public void swap(char[] nums, int a, int b) {
        char tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

// @lc code=end
