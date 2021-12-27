#
# @lc app=leetcode id=476 lang=python3
#
# [476] Number Complement
#

# @lc code=start

class Solution:
    def findComplement(self, num: int) -> int:
        res = 0
        exp = 0
        while num > 0:
            if num % 2 == 0:
                res += 2**exp
            exp += 1
            num = num//2

        return res

# @lc code=end
