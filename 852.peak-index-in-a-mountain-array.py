#
# @lc app=leetcode id=852 lang=python3
#
# [852] Peak Index in a Mountain Array
#

# @lc code=start

class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        # guaranteed to be a mountain
        l, r = 0, len(arr)-1
        while l < r:
            mid = (l+r)//2
            if arr[mid] < arr[mid+1]:
                l = mid+1
            else:
                r = mid
        return l


# @lc code=end
