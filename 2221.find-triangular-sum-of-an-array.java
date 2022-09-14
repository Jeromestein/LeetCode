/*
 * @lc app=leetcode id=2221 lang=java
 *
 * [2221] Find Triangular Sum of an Array
 */

// @lc code=start

class Solution {
    public int triangularSum(int[] nums) {
        for (int len = nums.length; len > 0; len--) {
            for (int i = 0; i < len - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0];
    }
}

// // Lucas
// class Solution {
// public int triangularSum(int[] nums) {
// int result = 0;
// int len = nums.length - 1;
// int mck = 1, exp2 = 0, exp5 = 0;
// int[] inv = { 0, 1, 0, 7, 0, 0, 0, 3, 0, 9 };
// int[] pow2mod10 = { 6, 2, 4, 8 };
// for (int k = 0; true; k++) {
// if (exp2 == 0 || exp5 == 0) {
// int mCk_ = exp2 > 0 ? mck * pow2mod10[exp2 % 4] : exp5 > 0 ? mck * 5 : mck;
// result = (result + mCk_ * nums[k]) % 10;
// }
// if (k == len)
// return result;

// // mCk *= m - k
// int mul = len - k;
// while (mul % 2 == 0) {
// mul /= 2;
// exp2++;
// }
// while (mul % 5 == 0) {
// mul /= 5;
// exp5++;
// }
// mck = mck * mul % 10;

// // mCk /= k + 1
// int div = k + 1;
// while (div % 2 == 0) {
// div /= 2;
// exp2--;
// }
// while (div % 5 == 0) {
// div /= 5;
// exp5--;
// }
// mck = mck * inv[div % 10] % 10;
// }
// }
// }
// @lc code=end
