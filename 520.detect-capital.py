#
# @lc app=leetcode id=520 lang=python3
#
# [520] Detect Capital
#

# @lc code=start

class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        if len(word) == 1:
            return True

        if word[0].isupper():
            if word[1].isupper():
                # 1. all upper
                for i in range(2, len(word)):
                    if not word[i].isupper():
                        return False
            else:
                # 2. first upper
                for i in range(2, len(word)):
                    if not word[i].islower():
                        return False

        else:
            # 3. all lower
            for i in range(len(word)):
                if not word[i].islower():
                    return False

        return True

# @lc code=end
