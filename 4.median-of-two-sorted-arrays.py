#
# @lc app=leetcode id=4 lang=python3
#
# [4] Median of Two Sorted Arrays
#

# @lc code=start


class Solution:
    def findMedianSortedArrays(self, A, B):
        l = len(A) + len(B)
        if l % 2 == 1:
            return self.kth(A, B, l // 2)
        else:
            return (self.kth(A, B, l // 2) + self.kth(A, B, l // 2 - 1)) / 2.

    def kth(self, a, b, k):
        if not a:
            return b[k]
        if not b:
            return a[k]
        medianIdxA, medianIdxB = len(a) // 2, len(b) // 2
        medianA, medianB = a[medianIdxA], b[medianIdxB]

        # when k is bigger than the sum of a and b's median indices
        if medianIdxA + medianIdxB < k:
            # if a's median is bigger than b's, b's first half doesn't include k
            if medianA > medianB:
                return self.kth(a, b[medianIdxB + 1:], k - medianIdxB - 1)
            else:
                return self.kth(a[medianIdxA + 1:], b, k - medianIdxA - 1)
        # when k is smaller than the sum of a and b's indices
        else:
            # if a's median is bigger than b's, a's second half doesn't include k
            if medianA > medianB:
                return self.kth(a[:medianIdxA], b, k)
            else:
                return self.kth(a, b[:medianIdxB], k)


# @lc code=end
