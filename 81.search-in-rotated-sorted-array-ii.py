#
# @lc app=leetcode id=81 lang=python3
#
# [81] Search in Rotated Sorted Array II
#

# @lc code=start

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums)-1
        while left < right:
            mid = (left+right)//2

            if nums[mid] == target:
                return True
            elif nums[mid] > nums[right]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid-1
                else:
                    left = mid+1
            elif nums[mid] < nums[right]:
                if nums[mid] < target and target <= nums[right]:
                    left = mid+1
                else:
                    right = mid-1
            else:
                right -= 1

        return left == right and nums[left] == target
    
# @lc code=end
