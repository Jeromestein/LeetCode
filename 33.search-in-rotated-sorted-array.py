#
# @lc app=leetcode id=33 lang=python3
#
# [33] Search in Rotated Sorted Array
#

# @lc code=start

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # All values of nums are unique.

        # 1. find min index
        l, r = 0, len(nums)-1
        while l < r:
            mid = (l+r)//2
            if nums[mid] < nums[r]:
                r = mid
            else:
                l = mid+1

        min = l
        # 2. decide the left and right index
        l, r = 0, len(nums)-1
        if nums[min] <= target and target <= nums[r]:
            l = min
        else:
            r = min-1

        # 3. binary search again
        while l < r:
            mid = (l+r)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                r = mid
            else:
                l = mid+1

        if nums[l] == target:
            return l
        else:
            return -1


# @lc code=end
