#
# @lc app=leetcode id=303 lang=python3
#
# [303] Range Sum Query - Immutable
#


# @lc code=start
class NumArray:

    def __init__(self, nums: List[int]):
        n = len(nums)
        self.pre_sum = [0] * n
        self.pre_sum[0] = nums[0]
        for i in range(1, n):
            self.pre_sum[i] = self.pre_sum[i - 1] + nums[i]

    def sumRange(self, left: int, right: int) -> int:
        if left == 0:
            return self.pre_sum[right]
        else:
            return self.pre_sum[right] - self.pre_sum[left - 1]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)
# @lc code=end
