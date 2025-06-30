#
# @lc app=leetcode id=69 lang=python3
#
# [69] Sqrt(x)
#

# @lc code=start

class Solution:
    def mySqrt(self, x: int) -> int:
        if x==0:
            return x
        
        left, right=1, x//2
        while left<right:
            mid=(left+right+1)//2
            if mid * mid >x:
                right=mid-1
            else:
                left=mid

        return left

            # @lc code=end
