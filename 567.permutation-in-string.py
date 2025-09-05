#
# @lc app=leetcode id=567 lang=python3
#
# [567] Permutation in String
#


# @lc code=start
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m, n = len(s1), len(s2)
        if m > n:
            return False

        s1_count = Counter(s1)
        s2_count = Counter(s2[:m])

        if s1_count == s2_count:
            return True

        left = 0
        for right in range(len(s1), len(s2)):
            s2_count[s2[right]] = 1 + s2_count.get(s2[right], 0)
            s2_count[s2[left]] -= 1

            if s2_count[s2[left]] == 0:
                del s2_count[s2[left]]

            left += 1

            if s1_count == s2_count:
                return True

        return False


# @lc code=end
