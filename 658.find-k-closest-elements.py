#
# @lc app=leetcode id=658 lang=python3
#
# [658] Find K Closest Elements
#

# @lc code=start

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # find start, return arr[start: start+k]
        left, right = 0, len(arr)-k
        while left < right:
            mid = (left+right)//2
            # Since `arr` is sorted, when comparing two windows of the same length for closeness to `x`,
            # we only need to compare the element farthest from `x` in each window:
            # - For the left window (`arr[mid : mid+k]`), the farthest element is its left endpoint `arr[mid]`
            #   (because the right endpoint lies closer to the center of the window).
            # - For the right window (`arr[mid+1 : mid+1+k]`), the farthest element is its right endpoint `arr[mid+k]`.
            if x - arr[mid] <= arr[mid+k]-x:
                right = mid
            else:
                left = mid+1

        return arr[left:left+k]

# @lc code=end
