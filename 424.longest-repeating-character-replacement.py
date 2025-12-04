#
# @lc app=leetcode id=424 lang=python3
#
# [424] Longest Repeating Character Replacement
#


# @lc code=start
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        start = 0
        freq_map = defaultdict(int)
        max_freq = 0
        longest_substring_length = 0
        for end in range(len(s)):
            freq_map[s[end]] += 1

            # the maximum frequency we have seen in any window yet
            max_freq = max(max_freq, freq_map[s[end]])

            # move the start pointer towards right if the current
            # window is invalid
            is_valid = end + 1 - start - max_freq <= k
            # Because we only expand the window by one character at a time, and max_freq never decreases,
            # the quantity window_length - max_freq can increase by at most 1 on each step.
            # Since the previous window was valid (≤ k), the new one is either still valid, or exactly k + 1.
            # In the latter case, shrinking the window by moving start once reduces the length by 1 and makes the window valid again.
            # That’s why a single left shift in the if block is always sufficient—no while loop is needed.
            if not is_valid:
                freq_map[s[start]] -= 1
                start += 1

            # the window is valid at this point, store length
            # size of the window never decreases
            # since the window size only stay or grow, so we dont need max()
            longest_substring_length = end + 1 - start

        return longest_substring_length


# @lc code=end
