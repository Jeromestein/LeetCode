#
# @lc app=leetcode id=3381 lang=python3
#
# [3381] Maximum Subarray Sum With Length Divisible by K
#


# @lc code=start
class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prefixSum = 0
        maxSum = -float("inf")

        # kSum[r] will store the **minimum prefix sum** among all prefix indices t
        # such that t % k == r.
        kSum = [float("inf")] * k

        # Trick:
        # Consider prefix index t = -1, with prefix sum P[-1] = 0 (sum of zero elements).
        # For t = -1, we define (-1) % k as k - 1 in Python (since -1 % k == k-1).
        #
        # This corresponds to the "empty prefix" before the array starts.
        # So we set:
        #    kSum[k-1] = 0
        # meaning:
        #    "the minimum prefix sum for remainder (k-1) is 0 at index -1".
        kSum[k - 1] = 0

        # Iterate over all elements as the end index of the subarray
        for i in range(n):
            # Update prefix sum up to index i: P[i] = P[i-1] + nums[i]
            prefixSum += nums[i]

            # We are at index i, with prefix sum P[i].
            # We want a starting prefix index t (meaning subarray starts at t+1)
            # such that:
            #   - The subarray length (i - (t+1) + 1) = i - t is divisible by k.
            #
            # That condition is: (i - t) % k == 0   =>   i % k == t % k.
            #
            # Also, the subarray sum is: P[i] - P[t].
            #
            # So for current i, we need the **minimum** P[t] over all t whose t % k == i % k.
            # We store this minimum in kSum[i % k].
            #
            # Candidate maximum sum if we end at i:
            #   prefixSum - (minimum prefix sum with same remainder)
            maxSum = max(maxSum, prefixSum - kSum[i % k])

            # Now we update kSum[i % k] with the current prefixSum,
            # because index i itself is a candidate "starting prefix" for future subarrays.
            # We take the minimum to always keep the smallest prefix sum for this remainder.
            kSum[i % k] = min(kSum[i % k], prefixSum)

        return maxSum


# @lc code=end
