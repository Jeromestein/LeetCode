#
# @lc app=leetcode id=326 lang=python3
#
# [326] Power of Three
#

# @lc code=start


class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        # [-2^31,2^31]
        # [-3^31,3^31]
        left, right = 0, 31
        if n <= 0:
            return False
        while left <= right:
            mid = (left + right) // 2
            x = 3**mid
            if x == n:
                return True
            elif x < n:
                left = mid + 1
            else:
                right = mid - 1

        return False


# @lc code=end
