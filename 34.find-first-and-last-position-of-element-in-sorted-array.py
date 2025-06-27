#
# @lc app=leetcode id=34 lang=python3
#
# [34] Find First and Last Position of Element in Sorted Array
#

# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # 1. find one target
        left, right = 0, len(nums)-1
        while left<=right:
            mid = (left+right)//2
            if nums[mid]==target:
                left=mid
                break
            elif nums[mid]<target:
                left=mid+1
            else:
                right=mid-1
        x=left
        if len(nums)==x or nums[x]!= target:
            return [-1,-1]
        # 2. find first 
        left, right = 0, x
        while left<right:
            mid = (left+right)//2
            # all e in nums[0,x] <= target
            if nums[mid]==target:
                right=mid
            else:
                left=mid+1

        first=left
        # 3. find last
        left, right = x, len(nums)-1
        while left<right:
            mid = (left+right+1)//2
            # all e in nums[0,x] >= target
            if nums[mid]==target:
                left=mid
            else:
                right=mid-1

        last=left

        return [first, last]

# @lc code=end
