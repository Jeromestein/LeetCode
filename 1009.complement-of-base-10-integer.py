#
# @lc app=leetcode id=1009 lang=python3
#
# [1009] Complement of Base 10 Integer
#

# @lc code=start

# Built-in Functions to Construct 1-bits Bitmask
class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if n == 0:
            return 1
        else:
            return (1 << n.bit_length())-n-1

# @lc code=end
