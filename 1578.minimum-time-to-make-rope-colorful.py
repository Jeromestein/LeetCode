#
# @lc app=leetcode id=1578 lang=python3
#
# [1578] Minimum Time to Make Rope Colorful
#

# @lc code=start


class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        # totalTime: total time needed to make rope colorful;
        # currMaxTime: maximum(longest) time of a balloon needed in this group.
        total_time = 0
        curr_max_time = 0

        # For each balloon in the array:
        n = len(colors)
        for i in range(n):
            # If this balloon is the first balloon of a new group
            # set the curr_max_time as 0.
            if i > 0 and colors[i] != colors[i - 1]:
                curr_max_time = 0

            # Increment total_time by the smaller one.
            # Update curr_max_time as the larger one.
            total_time += min(curr_max_time, neededTime[i])
            curr_max_time = max(curr_max_time, neededTime[i])

        # Return total_time as the minimum removal time.
        return total_time


# @lc code=end
