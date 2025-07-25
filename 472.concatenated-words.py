#
# @lc app=leetcode id=472 lang=python3
#
# [472] Concatenated Words
#

# @lc code=start


class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        word_set = set(words)
        result = []

        for word in words:
            if not word:
                continue
            # Remove the word itself to prevent using it in its own construction
            word_set.remove(word)
            if self.canForm(word, word_set):
                result.append(word)
            # Add it back for the next iteration
            word_set.add(word)

        return result

    def canForm(self, word, word_set):
        n = len(word)
        # dp[i] means word[:i] can be formed by words in word_set
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(n):
            if not dp[i]:
                continue
            # Try every possible next cut
            for j in range(i + 1, n + 1):
                # If the substring word[i:j] exists in the set,
                # mark dp[j] = True
                if word[i:j] in word_set:
                    dp[j] = True
                    # Early exit: if we've reached the end, it's formable
                    if j == n:
                        return True
        return False


# @lc code=end
