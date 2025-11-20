#
# @lc app=leetcode id=259 lang=python3
#
# [259] 3Sum Smaller
#


# @lc code=start
class Solution:
    def threeSumSmaller(self, nums, target):
        nums.sort()
        total = 0
        for i in range(len(nums) - 2):
            total += self.twoSumSmaller(nums[i + 1 :], target - nums[i])

        return total

    def twoSumSmaller(self, nums, target):
        count = 0
        left, right = 0, len(nums) - 1

        while left < right:
            if nums[left] + nums[right] < target:
                count += right - left
                left += 1
            else:
                right -= 1

        return count


# @lc code=end
