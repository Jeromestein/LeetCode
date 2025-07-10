#
# @lc app=leetcode id=3440 lang=python3
#
# [3440] Reschedule Meetings for Maximum Free Time II
#

# @lc code=start


class Solution:
    def maxFreeTime(self, eventTime: int, startTime: List[int], endTime: List[int]) -> int:
        n = len(startTime)
        # Append dummy end so we can compute the last gap uniformly
        start = startTime + [eventTime]
        end   = endTime
        
        # Track the three largest gaps and their indices
        gaps = [0] * 3
        ids  = [0, 1, 2]
        
        # Initialize first three gaps
        gaps[0] = start[0]               # gap before meeting 0
        gaps[1] = start[1] - end[0]      # gap between meeting 0 and 1
        gaps[2] = start[2] - end[1]      # gap between meeting 1 and 2
        
        # Bubble‐sort those three so gaps[0] ≥ gaps[1] ≥ gaps[2]
        if gaps[0] < gaps[1]:
            gaps[0], gaps[1] = gaps[1], gaps[0]
            ids [0], ids [1] = ids [1], ids [0]
        if gaps[1] < gaps[2]:
            gaps[1], gaps[2] = gaps[2], gaps[1]
            ids [1], ids [2] = ids [2], ids [1]
        if gaps[0] < gaps[1]:
            gaps[0], gaps[1] = gaps[1], gaps[0]
            ids [0], ids [1] = ids [1], ids [0]

        # Extend the top‐3 list by scanning the rest of the gaps
        for i in range(3, n + 1):
            curr_gap = start[i] - end[i - 1]
            if curr_gap >= gaps[0]:
                # shift everything down, put curr_gap at 0
                gaps[2], gaps[1], gaps[0] = gaps[1], gaps[0], curr_gap
                ids [2], ids [1], ids [0] = ids [1], ids [0], i
            elif curr_gap >= gaps[1]:
                gaps[2], gaps[1] = gaps[1], curr_gap
                ids [2], ids [1] = ids [1], i
            elif curr_gap > gaps[2]:
                gaps[2] = curr_gap
                ids [2]  = i

        # Helper to decide max free time impact of moving meeting i
        def jump_or_shift(i: int) -> int:
            busy = end[i] - start[i]
            # can we jump into any nonadjacent top-3 gap?
            for k in range(3):
                g_id = ids[k]
                if gaps[k] >= busy and g_id != i and g_id != i + 1:
                    # jump: free slot is immediately around meeting i
                    left  = 0 if i == 0 else end[i - 1]
                    right = eventTime if i == n - 1 else start[i + 1]
                    return right - left
            # otherwise we can only shift it into its own adjacent gap
            left  = 0 if i == 0 else end[i - 1]
            right = eventTime if i == n - 1 else start[i + 1]
            return (right - left) - busy

        # Compute the answer by testing each meeting
        ans = 0
        for i in range(n):
            ans = max(ans, jump_or_shift(i))
        return ans

# @lc code=end

