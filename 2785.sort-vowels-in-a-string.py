#
# @lc app=leetcode id=2785 lang=python3
#
# [2785] Sort Vowels in a String
#

# @lc code=start


class Solution:
    def isVowel(self, c: str) -> bool:
        # Helper function: return True if c is a vowel (uppercase or lowercase)
        return c in "aeiouAEIOU"

    def sortVowels(self, s: str) -> str:
        # Step 1. Count the frequency of each vowel
        count = {ch: 0 for ch in "AEIOUaeiou"}
        for c in s:
            if self.isVowel(c):
                count[c] += 1

        # Step 2. Define the sorted order of vowels
        sortedVowel = "AEIOUaeiou"
        ans = []
        j = 0  # pointer to the current position in sortedVowel

        # Step 3. Traverse the original string
        for ch in s:
            if not self.isVowel(ch):
                # If it is not a vowel, keep it unchanged
                ans.append(ch)
            else:
                # Find the next vowel that still has remaining count
                while j < len(sortedVowel) and count[sortedVowel[j]] == 0:
                    j += 1
                ans.append(sortedVowel[j])
                count[sortedVowel[j]] -= 1

        # Step 4. Return the final string
        return "".join(ans)


# @lc code=end
