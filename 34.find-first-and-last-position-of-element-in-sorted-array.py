#
# @lc app=leetcode id=34 lang=python3
#
# [34] Find First and Last Position of Element in Sorted Array
#

# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==0:
            return [-1, -1]
        # 1. find the first target
        def firstTarget(nums: List[int], target: int) -> List[int]:
            left, right = 0, len(nums)-1
            while left < right:
                mid = (left + right )//2
                if nums[mid] >= target:
                    right = mid
                else: 
                    left = mid+1
            
            if nums[right] == target:
                print(right)
                return right
            else:
                return -1

        # 2. find the last target
        def lastTarget(nums: List[int], target: int) -> List[int]:
            left, right = 0, len(nums)-1
            while left < right:
                mid = (left + right+1 )//2
                if nums[mid] <= target:
                    left = mid
                else: 
                    right = mid-1
            
            if nums[left] == target:
                print(left)
                return left
            else:
                return -1

        left = firstTarget(nums, target)
        right = lastTarget(nums, target)

        return [left, right]

# @lc code=end
