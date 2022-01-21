#
# @lc app=leetcode id=69 lang=python3
#
# [69] Sqrt(x)
#

# @lc code=start

class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        else:
            l, r = 1, x//2
            while l < r:
                mid = l+(r-l)//2
                if mid*mid <= x and (mid+1)*(mid+1) > x:
                    return mid
                elif mid*mid > x:
                    r = mid-1
                else:
                    l = mid+1

            return l

            # @lc code=end
