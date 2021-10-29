#
# @lc app=leetcode id=34 lang=python3
#
# [34] Find First and Last Position of Element in Sorted Array
#

# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = self.findBound(nums, target, True)
        if start == -1:
            return [-1, -1]
        else:
            end = self.findBound(nums, target, False)
            return [start, end]

    def findBound(self, nums: List[int], target: int, isFirst: bool) -> int:
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l+r)//2
            if nums[mid] == target:
                if isFirst:
                    if mid == l or nums[mid-1] < target:
                        return mid
                    else:
                        r = mid-1
                else:
                    if mid == r or nums[mid+1] > target:
                        return mid
                    else:
                        l = mid+1

            elif nums[mid] > target:
                r = mid-1
            else:
                l = mid+1

        return -1

# @lc code=end
