#
# @lc app=leetcode id=239 lang=python3
#
# [239] Sliding Window Maximum
#


# @lc code=start
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        # # stores pairs (index, value)
        # in val's decreasing value order
        dq = deque()
        res = []

        # Initialize deque with the first window
        for i in range(k):
            # Remove all smaller values from the back,
            # since they cannot be the maximum if a larger arrives
            while dq and nums[i] >= dq[-1][1]:
                dq.pop()
            dq.append((i, nums[i]))
        res.append(dq[0][1])

        # Process the rest of the windows
        for i in range(k, n):
            # Remove the element that slid out of the window
            if dq and dq[0][0] == i - k:
                dq.popleft()

            while dq and nums[i] >= dq[-1][1]:
                dq.pop()
            dq.append((i, nums[i]))
            res.append(dq[0][1])

        return res


# @lc code=end
