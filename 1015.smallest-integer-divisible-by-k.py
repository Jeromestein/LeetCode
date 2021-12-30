#
# @lc app=leetcode id=1015 lang=python3
#
# [1015] Smallest Integer Divisible by K
#

# @lc code=start

class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        # 1, 11, 111, 1111, ..., 111...1111
        # 1. use remainder to avoid the overflow
        # 2. len should never longer than k itself
        remainder = 0
        for len in range(1, k+1):
            remainder = (remainder*10+1) % k
            if remainder == 0:
                return len
        return -1

# @lc code=end
