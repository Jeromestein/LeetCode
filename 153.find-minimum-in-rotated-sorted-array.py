#
# @lc app=leetcode id=153 lang=python3
#
# [153] Find Minimum in Rotated Sorted Array
#

# @lc code=start
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1

        while l < r:
            mid = (l+r)//2
            # All the integers of nums are unique.
            if nums[mid] < nums[r]:
                r = mid
            else:
                l = mid+1

        return nums[l]

# @lc code=end
