#
# @lc app=leetcode id=845 lang=python3
#
# [845] Longest Mountain in Array
#

# @lc code=start
class Solution(object):
    def longestMountain(self, A):
        n = len(A)
        maxLen = start = 0

        while start < n:
            end = start
            if end + 1 < n and A[end] < A[end + 1]: #if start is a left-boundary
                #set end to the peak of this potential mountain
                while end + 1 < n and A[end] < A[end + 1]:
                    end += 1

                if end + 1 < n and A[end] > A[end + 1]: #if end is really a peak..
                    #set 'end' to right-boundary of mountain
                    while end + 1 < n and A[end] > A[end + 1]:
                        end += 1
                    #record candidate answer
                    maxLen = max(maxLen, end - start + 1)

            start = max(end, start + 1)

        return maxLen
# @lc code=end

