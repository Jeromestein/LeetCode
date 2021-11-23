#
# @lc app=leetcode id=658 lang=python3
#
# [658] Find K Closest Elements
#

# @lc code=start

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # find start, return arr[start: start+k]
        l, r = 0, len(arr)-k
        while l < r:
            mid = (l+r)//2
            if x - arr[mid] <= arr[mid+k]-x:
                r = mid
            else:
                l = mid+1

        return arr[l:l+k]

# @lc code=end
