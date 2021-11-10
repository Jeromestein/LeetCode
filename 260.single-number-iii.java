/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start

class Solution {
    public int[] singleNumber(int[] nums) {
        // we use XOR operation to find the
        // difference between two numbers (x and y) which were seen only once
        // (a^b^b^x^y^a=x^y)
        int bitmask = 0;
        for (int num : nums)
            bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums)
            // use diff as a filter to skip y (and maybe other element, doesnt matter)
            if ((num & diff) != 0)
                x ^= num;

        return new int[] { x, bitmask ^ x };
    }
}

// @lc code=end
