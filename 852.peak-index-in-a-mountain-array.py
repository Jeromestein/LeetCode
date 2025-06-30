#
# @lc app=leetcode id=852 lang=python3
#
# [852] Peak Index in a Mountain Array
#

# @lc code=start

class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        # guaranteed to be a mountain
        left, right = 0, len(arr)-1
        while left < right:
            mid = (left+right)//2
            # of course, arr[mid+1] exists
            if arr[mid] < arr[mid+1]:
                left = mid+1
            else:
                right = mid
        return left


# @lc code=end
