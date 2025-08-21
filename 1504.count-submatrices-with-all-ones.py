#
# @lc app=leetcode id=1504 lang=python3
#
# [1504] Count Submatrices With All Ones
#

# @lc code=start


from typing import List


class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        """
        Count submatrices with all 1s.

        Idea:
        - Treat each row as the base of a histogram: heights[c] = consecutive 1's
          ending at current row in column c.
        - For each row's histogram, count the number of all-1 submatrices whose
          bottom edge is this row. This equals the number of all-positive-width
          sub-rectangles in the histogram that end at each column.
        - Use a monotonic (non-decreasing height) stack to compute, in O(m) per row,
          how many rectangles end at each column.

        Stack element format: [idx, acc, h]
          - idx: the previous index to the left with height < h (after pops)
          - acc: the total number of submatrices ending at columns up to idx under
                 the current "effective base" (pre-accumulated count)
          - h:   the height at that anchor
        Sentinel: [-1, 0, -1] to simplify edge cases.
        """
        rows, cols = len(mat), len(mat[0])
        heights = [0] * cols  # histogram heights for current row
        total = 0

        for row in mat:
            # 1) Update histogram heights from the current row
            for c, val in enumerate(row):
                heights[c] = 0 if val == 0 else heights[c] + 1

            # 2) Monotonic stack to count submatrices ending at this row
            #    stack keeps increasing heights by their "effective" left boundary
            stack = [[-1, 0, -1]]  # [last_smaller_index, accumulated_count, height]

            for i, h in enumerate(heights):
                # Maintain non-decreasing stack by popping >= current height.
                # After popping, the top has height < h and acts as the nearest
                # smaller to the left boundary for height h at position i.
                while stack[-1][2] >= h:
                    stack.pop()

                # The top describes the last position j where height < h.
                # 'prev' is the accumulated count up to j with its effective height.
                j, prev, _ = stack[-1]

                # Number of submatrices with bottom at current row and RIGHT edge at i:
                #   = previous accumulated count 'prev'
                #     + (i - j) * h
                # Explanation:
                # - For each possible width ending at i (from j+1..i), the limiting
                #   height is at least h (since all heights between (j, i] >= h).
                # - That contributes h rectangles for each width; summing widths gives
                #   (i - j) * h additional submatrices anchored by this new bar.
                cur = prev + (i - j) * h

                # Push current state; this becomes the new anchor for future columns.
                stack.append([i, cur, h])

                # Accumulate into the global answer: all rectangles ending at i
                total += cur

        return total


# @lc code=end
