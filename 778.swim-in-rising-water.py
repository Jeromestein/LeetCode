#
# @lc app=leetcode id=778 lang=python3
#
# [778] Swim in Rising Water
#


# @lc code=start
class Solution(object):
    def swimInWater(self, grid):
        # N is the size of the grid (N x N)
        N = len(grid)

        # Helper function: checks whether it is possible
        # to reach the bottom-right cell (N-1, N-1)
        # when the water level is at most T.
        def possible(T):
            # Start DFS (stack-based) from the top-left corner
            stack = [(0, 0)]
            # 'seen' keeps track of visited cells to avoid cycles
            seen = {(0, 0)}

            while stack:
                r, c = stack.pop()

                # If we've reached the target cell, return True
                if r == c == N - 1:
                    return True

                # Explore all 4 directions (up, down, left, right)
                for cr, cc in ((r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)):
                    # Only move if:
                    # 1. new position is within bounds
                    # 2. not visited yet
                    # 3. the height of that cell <= current water level (T)
                    if (
                        0 <= cr < N
                        and 0 <= cc < N
                        and (cr, cc) not in seen
                        and grid[cr][cc] <= T
                    ):
                        # Mark as visited and add to stack
                        stack.append((cr, cc))
                        seen.add((cr, cc))

            # If stack empties and we never reached the goal → not possible
            return False

        # Binary search over possible water levels.
        # Minimum possible level = height at starting cell
        # Maximum possible level = N * N (upper bound for heights)
        lo, hi = grid[0][0], N * N

        while lo < hi:
            # mid = current candidate water level
            # use '//' for integer division (Python 3 safe)
            mi = (lo + hi) // 2

            # Check if we can reach the goal at this water level
            if not possible(mi):
                # If not possible, we need higher water → search right half
                lo = mi + 1
            else:
                # If possible, try to find a smaller valid water level
                hi = mi

        # When loop ends, lo == hi == minimum water level required
        return lo


# @lc code=end
