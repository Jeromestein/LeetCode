#
# @lc app=leetcode id=395 lang=python3
#
# [395] Longest Substring with At Least K Repeating Characters
#

# @lc code=start


class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        # If k is 0, every substring is valid
        if k == 0:
            return len(s)

        n = len(s)
        res = 0
        # Maximum distinct characters we need to consider is limited by the string itself
        max_unique = len(set(s))

        # Try every possible target number of distinct characters in the window
        for target in range(1, max_unique + 1):
            count = defaultdict(int)
            left = 0
            right = 0
            unique = 0  # current number of distinct characters in window
            no_less_than_k = 0  # number of characters in window with freq >= k

            # Expand window by moving right
            while right < n:
                c = s[right]
                if count[c] == 0:
                    unique += 1
                count[c] += 1
                if count[c] == k:
                    no_less_than_k += 1
                right += 1

                # Shrink window from the left if we exceed target distinct chars
                while unique > target:
                    d = s[left]
                    if count[d] == k:
                        no_less_than_k -= 1
                    count[d] -= 1
                    if count[d] == 0:
                        unique -= 1
                    left += 1

                # If window has exactly 'target' distinct chars,
                # and all of them appear at least k times,
                # update the maximum length
                if unique == target and no_less_than_k == target:
                    res = max(res, right - left)

        return res


# @lc code=end
