#
# @lc app=leetcode id=2014 lang=python3
#
# [2014] Longest Subsequence Repeated k Times
#

# @lc code=start

class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        ans = ""  
        # 1. Filter out characters that appear at least k times,
        #    sort them in descending order for lexicographical control.
        candidate = sorted(
            [char for char, freq in Counter(s).items() if freq >= k],
            reverse=True
        )
        # 2. Initialize a queue with each single-character candidate
        # For deque:
        # •	popleft()：O(1)
        # •	append()：O(1)
        q = deque(candidate)

        # 3. BFS: try extending each current string by one more char
        while q:
            curr = q.popleft()  
            # If this candidate is longer than previous best, update answer
            if len(curr) > len(ans):
                ans = curr

            # For each possible next character, form a new candidate
            for char in candidate:
                next = curr + char 
                # Create an iterator over s to check subsequence membership
                it = iter(s)
                # Check if `next` repeated k times can be found as a subsequence
                # i.e., next*next*... (k times) each char in order
                if all(char in it for char in next * k):
                    # If valid, enqueue for further extension
                    q.append(next)

        # 4. Return the longest valid subsequence found
        return ans

# @lc code=end

