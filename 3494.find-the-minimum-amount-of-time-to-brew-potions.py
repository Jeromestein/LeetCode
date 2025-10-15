#
# @lc app=leetcode id=3494 lang=python3
#
# [3494] Find the Minimum Amount of Time to Brew Potions
#


# @lc code=start
class Solution:
    def minTime(self, skill: List[int], mana: List[int]) -> int:
        # n = number of skills (workers or tasks)
        # m = number of mana values (energy levels or operations)
        n, m = len(skill), len(mana)

        # times[i] represents the accumulated time after processing up to skill i
        times = [0] * n

        # Iterate over each mana value (each "round" or "phase")
        for j in range(m):
            cur_time = 0
            # Forward pass: compute total time if we apply mana[j] to all skills
            for i in range(n):
                # Each skill i takes (skill[i] * mana[j]) extra time
                # The start time for the current skill must be after all previous tasks are finished,
                # so we take max(cur_time, times[i]).
                cur_time = max(cur_time, times[i]) + skill[i] * mana[j]

            # After the forward pass, record the total time for the last skill
            times[n - 1] = cur_time

            # Backward pass: propagate adjusted completion times for earlier skills
            # (so that the "end time" chain is consistent with this round’s cost)
            for i in range(n - 2, -1, -1):
                # Each earlier skill finishes earlier by subtracting the last segment cost
                times[i] = times[i + 1] - skill[i + 1] * mana[j]

        # The last element stores the final minimum total time
        return times[n - 1]


# @lc code=end
