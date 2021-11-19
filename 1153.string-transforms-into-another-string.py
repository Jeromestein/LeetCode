#
# @lc app=leetcode id=1153 lang=python3
#
# [1153] String Transforms Into Another String
#

# @lc code=start

class Solution:
    def canConvert(self, str1: str, str2: str) -> bool:
        if str1 == str2:
            return True

        convertMap = dict()
        letterSet = set()

        for char1, char2 in zip(str1, str2):
            if char1 not in convertMap:
                convertMap[char1] = char2
                letterSet.add(char2)
            elif convertMap[char1] != char2:
                return False

        # if len(letterSet) == 26,
        # "abcdefghijklmnopqrstuvwxyz" -> "bcdefghijklmnopqrstuvwxyza"
        # 1. "abcdefghijklmnopqrstuvwxyz" -> "abcdefghijklmnopqrstuvwxya"
        # 2. "abcdefghijklmnopqrstuvwxya" -> "bbcdefghijklmnopqrstuvwxyb"
        # ... impossible
        return len(letterSet) < 26


# @lc code=end
