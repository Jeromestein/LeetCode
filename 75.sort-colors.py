#
# @lc app=leetcode id=75 lang=python3
#
# [75] Sort Colors
#

# @lc code=start
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
        Sorts the array in-place so that all 0s come first, then 1s, then 2s.
        Implements the Dutch National Flag algorithm in O(n) time and O(1) space.
        """
        # Initialize three pointers:
        # p0 marks the boundary for next position of 0.
        # p2 marks the boundary for next position of 2.
        # curr scans the array from left to right.
        p0 = 0
        curr = 0
        p2 = len(nums) - 1

        # Process elements until curr surpasses p2.
        while curr <= p2:
            if nums[curr] == 0:
                # Swap current 0 into the next p0 position.
                nums[p0], nums[curr] = nums[curr], nums[p0]
                p0 += 1
                curr += 1
            elif nums[curr] == 2:
                # Swap current 2 into the p2 position.
                nums[curr], nums[p2] = nums[p2], nums[curr]
                p2 -= 1
                # Note: do NOT increment curr here,
                # because the swapped-in element needs examination.
            else:
                # nums[curr] == 1, leave it in place.
                curr += 1
        
# @lc code=end

