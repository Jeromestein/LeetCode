#
# @lc app=leetcode id=702 lang=python3
#
# [702] Search in a Sorted Array of Unknown Size
#

# @lc code=start
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        l, r = 0, 10001
        while l <= r:
            mid = (l+r)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                r = mid-1
            else:
                l = mid+1

        return -1
# @lc code=end
