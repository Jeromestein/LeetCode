#
# @lc app=leetcode id=33 lang=python3
#
# [33] Search in Rotated Sorted Array
#

# @lc code=start

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # All values of nums are unique.
        # 1. find minimum's index
        left, right = 0, len(nums)-1
        while left<right:
            mid = (left+right)//2
            if nums[mid]>nums[right]:
                left=mid+1
            else:
                right=mid
        
        minIdx=left
        # 2. which half to search target?
        left, right = 0, len(nums)-1
        if target > nums[right]:
            right=minIdx-1
        else:
            left=minIdx
        # 3. binary search
        while left<=right:
            mid = (left+right)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                left=mid+1
            else:
                right=mid-1
        return -1


# @lc code=end
