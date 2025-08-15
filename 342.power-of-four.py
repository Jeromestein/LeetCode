#
# @lc app=leetcode id=342 lang=python3
#
# [342] Power of Four
#


# @lc code=start
class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        # [2^31] -> [4^16]
        if n < 1:
            return False

        left, right = 0, 16
        while left <= right:
            mid = (left + right) // 2
            x = 4**mid
            if x == n:
                return True
            elif x < n:
                left = mid + 1
            else:
                right = mid - 1

        return False


# @lc code=end
