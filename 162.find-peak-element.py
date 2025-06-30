#
# @lc app=leetcode id=162 lang=python3
#
# [162] Find Peak Element
#

# @lc code=start


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # nums[-1] = nums[n] = -∞ guarantees at least one peak
        left, right = 0, len(nums)-1

        # check if the slope is rising to the right or falling to the left
        while left < right:
            mid = (left+right)//2
            # If the slope is rising to the right, a peak must lie in (mid+1, r]
            if nums[mid] < nums[mid+1]:
                left = mid+1
            else:
                right = mid

        return left


# @lc code=end
