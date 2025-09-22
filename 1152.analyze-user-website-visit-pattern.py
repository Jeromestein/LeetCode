#
# @lc app=leetcode id=1152 lang=python3
#
# [1152] Analyze User Website Visit Pattern
#

# @lc code=start


class Solution:
    def mostVisitedPattern(
        self, username: List[str], timestamp: List[int], website: List[str]
    ) -> List[str]:
        from itertools import combinations, permutations

        # Step 1. Build user trajectories
        # user_traj[u] = SortedList of (timestamp, website), sorted by time
        user_traj = defaultdict(SortedList)
        for u, t, w in zip(username, timestamp, website):
            user_traj[u].add((t, w))

        # Step 2. Count 3-sequence patterns across all users
        traj_counts = defaultdict(int)
        for u in user_traj:
            order_w = [w for _, w in user_traj[u]]  # get websites in time order

            seen_patterns = set()

            # Generate all 3-combinations of this user's trajectory
            for p in combinations(order_w, 3):
                seen_patterns.add(p)

            # Update global frequency (each user contributes at most 1 count per pattern)
            for pat in seen_patterns:
                traj_counts[pat] += 1

        # Step 3. Find max frequency
        max_v = max(traj_counts.values())

        # Step 4. Collect all candidates with same max frequency
        cands = SortedList()
        for k in traj_counts:
            if traj_counts[k] == max_v:
                cands.add(k)

        # Step 5. Return lexicographically smallest one
        return cands[0]


# @lc code=end
