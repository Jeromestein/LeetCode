#
# @lc app=leetcode id=42 lang=python3
#
# [42] Trapping Rain Water
#

# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left, right = 0, n - 1      # 双指针初始指向两端
        left_max, right_max = 0, 0  # 记录到目前为止左右两端最高的“墙”
        ans = 0                     # 累计答案

        while left < right:
            if height[left] < height[right]:
                # 左边较低，以左边为限，能接的水 = left_max - height[left]
                if height[left] >= left_max:
                    left_max = height[left]  # 更新左侧最高
                else:
                    ans += left_max - height[left]
                left += 1
            else:
                # 右边较低，以右边为限，能接的水 = right_max - height[right]
                if height[right] >= right_max:
                    right_max = height[right]  # 更新右侧最高
                else:
                    ans += right_max - height[right]
                right -= 1

        return ans
        
# @lc code=end

