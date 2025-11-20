#
# @lc app=leetcode id=717 lang=python3
#
# [717] 1-bit and 2-bit Characters
#


# @lc code=start
class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        n = len(bits)
        # find last character
        i = 0
        while i < n - 1:
            if bits[i] == 0:
                i += 1
            if bits[i] == 1:
                i += 2

        return i == n - 1


# @lc code=end
