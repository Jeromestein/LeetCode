#
# @lc app=leetcode id=3370 lang=python3
#
# [3370] Smallest Number With All Set Bits
#

# @lc code=start


class Solution:
    def smallestNumber(self, n: int) -> int:
        res = 1
        for i in range(n.bit_length() - 1):
            res <<= 1
            res += 1
        return res


# @lc code=end
