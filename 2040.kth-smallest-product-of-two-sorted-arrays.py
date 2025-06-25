#
# @lc app=leetcode id=2040 lang=python3
#
# [2040] Kth Smallest Product of Two Sorted Arrays
#

# @lc code=start
class Solution:
    def kthSmallestProduct(
        self, nums1: List[int], nums2: List[int], k: int
    ) -> int:
        # Partition nums1 and nums2 into negative and non-negative parts
        n1, n2 = len(nums1), len(nums2)
        pos1 = 0
        while pos1 < n1 and nums1[pos1] < 0:
            pos1 += 1
        pos2 = 0
        while pos2 < n2 and nums2[pos2] < 0:
            pos2 += 1

        # Search range for product values
        left, right = -(10**10), 10**10

        # Binary search on the answer domain
        while left <= right:
            mid = (left + right) // 2
            count = 0

            # 1) Negative nums1 × Negative nums2 -> Positive products
            i1, i2 = 0, pos2 - 1
            while i1 < pos1 and i2 >= 0:
                prod = nums1[i1] * nums2[i2]
                if prod > mid:
                    # If product too large, move i1 to reduce magnitude
                    # (Walk through nums1 from left to right)
                    i1 += 1
                else:
                    # All pairs from i1..pos1-1 with this i2 are ≤ mid
                    count += pos1 - i1
                    i2 -= 1

            # 2) Non-negative nums1 × Non-negative nums2 -> Positive products
            i1, i2 = pos1, n2 - 1
            while i1 < n1 and i2 >= pos2:
                prod = nums1[i1] * nums2[i2]
                if prod > mid:
                    # If product too large, move i2 to reduce magnitude
                    i2 -= 1
                else:
                    # All pairs from pos2..i2 with this i1 are ≤ mid
                    count += i2 - pos2 + 1
                    i1 += 1

            # 3) Negative nums1 × Non-negative nums2 -> Negative products
            i1, i2 = 0, pos2
            while i1 < pos1 and i2 < n2:
                prod = nums1[i1] * nums2[i2]
                if prod > mid:
                    # If negative product > mid (mid may be negative), i2++
                    i2 += 1
                else:
                    # All pairs from i2..n2-1 with this i1 are ≤ mid
                    count += n2 - i2
                    i1 += 1

            # 4) Non-negative nums1 × Negative nums2 -> Negative products
            i1, i2 = pos1, 0
            while i1 < n1 and i2 < pos2:
                prod = nums1[i1] * nums2[i2]
                if prod > mid:
                    # If negative product > mid, i1++
                    i1 += 1
                else:
                    # All pairs from i1..n1-1 with this i2 are ≤ mid
                    count += n1 - i1
                    i2 += 1

            # Adjust binary search range based on count
            if count < k:
                left = mid + 1    # too few, increase mid
            else:
                right = mid - 1   # enough or too many, decrease mid

        # left is the k-th smallest product
        return left
    
    
# class Solution:
#     # Count how many x2 in nums2 satisfy x1 * x2 <= v
#     def f(self, nums2: List[int], x1: int, v: int) -> int:
#         if x1 > 0:
#             # For positive x1, inequality direction stays the same:
#             # x2 <= v // x1
#             return bisect_right(nums2, v // x1)
#         elif x1 < 0:
#             # For negative x1, inequality direction reverses:
#             # x2 >= ceil(v / x1)
#             # Use -(-v // x1) to compute ceil for negative division
#             threshold = -(-v // x1)
#             idx = bisect_left(nums2, threshold)
#             return len(nums2) - idx
#         else:
#             # x1 == 0 -> product is always 0
#             # Count all if v >= 0, else none
#             return len(nums2) if v >= 0 else 0

#     def kthSmallestProduct(
#         self, nums1: List[int], nums2: List[int], k: int
#     ) -> int:
#         # Search range
#         n1 = len(nums1)
#         left, right = -(10**10), 10**10
#         while left <= right:
#             mid = (left + right) // 2
#             # Count how many products are <= mid
#             count = 0
#             for i in range(n1):
#                 count += self.f(nums2, nums1[i], mid)  # Count x2 for each x1
            
#             if count < k:
#                 # Too few products, increase lower bound
#                 left = mid + 1
#             else:
#                 # Too many products, decrease upper bound
#                 right = mid - 1
#         return left


# @lc code=end

