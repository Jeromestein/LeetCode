#
# @lc app=leetcode id=4 lang=python3
#
# [4] Median of Two Sorted Arrays
#

# @lc code=start


class Solution:
    def findMedianSortedArrays(self, A, B):
        length = len(A) + len(B)
        if length % 2 == 1:
            return self.findKthMin(A, B, length // 2)
        else:
            return (self.findKthMin(A, B, length // 2) + self.findKthMin(A, B, length // 2 - 1)) / 2.

    def findKthMin(self, a, b, k):
        # 1. if one of the arrays is empty, return the k-th element of the other array
        if not a:
            return b[k]
        if not b:
            return a[k]
        medianIdxA, medianIdxB = len(a) // 2, len(b) // 2
        medianA, medianB = a[medianIdxA], b[medianIdxB]

        # if k is bigger than the sum of a and b's median indices
        if medianIdxA + medianIdxB < k:
            # if a's median is bigger than b's, b's first half doesn't include k
            if medianA > medianB:
                return self.findKthMin(a, b[medianIdxB + 1:], k - (medianIdxB + 1))
            else:
                return self.findKthMin(a[medianIdxA + 1:], b, k - (medianIdxA + 1))
        # when k is smaller than the sum of a and b's indices
        else:
            # if a's median is bigger than b's, a's second half doesn't include k
            if medianA > medianB:
                return self.findKthMin(a[:medianIdxA], b, k)
            else:
                return self.findKthMin(a, b[:medianIdxB], k)


# @lc code=end
