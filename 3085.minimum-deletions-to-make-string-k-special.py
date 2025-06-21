#
# @lc app=leetcode id=3085 lang=python3
#
# [3085] Minimum Deletions to Make String K-Special
#

# @lc code=start
class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        # defaultdict is a dictionary that will not raise an error if the key is not found
        count = defaultdict(int)
        for char in word:
            count[char] += 1
        res = len(word)
        for a in count.values():
            deleted=0
            for b in count.values():
                if a > b:
                    deleted += b
                elif b > a + k:
                    deleted += b-(a + k)
            res = min(res, deleted)
        return res


# @lc code=end

