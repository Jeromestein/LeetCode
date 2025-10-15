#
# @lc app=leetcode id=3349 lang=python3
#
# [3349] Adjacent Increasing Subarrays Detection I
#

# @lc code=start


class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        # cnt: length of the current strictly increasing subarray
        # precnt: length of the previous strictly increasing subarray
        # ans: stores the maximum possible k′ found so far
        cnt, precnt, ans = 1, 0, 0

        # Traverse the array to track lengths of consecutive increasing segments
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                # Continue the current increasing subarray
                cnt += 1
            else:
                # Current increasing sequence ends
                # Shift current count to previous, and reset cnt
                precnt, cnt = cnt, 1

            # Case 1: Two adjacent increasing subarrays
            # The maximum possible adjacent subarray length k′ = min(precnt, cnt)
            ans = max(ans, min(precnt, cnt))

            # Case 2: Both increasing subarrays are part of a single long segment
            # Then k′ can be floor(cnt / 2)
            ans = max(ans, cnt // 2)

        # If the largest k′ we found is at least k, the condition holds
        return ans >= k


# @lc code=end
