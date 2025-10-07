#
# @lc app=leetcode id=1135 lang=python3
#
# [1135] Connecting Cities With Minimum Cost
#

# @lc code=start


class Solution:
    def minimumCost(self, n: int, connections: List[List[int]]) -> int:
        # Step 1. Sort edges by cost (ascending)
        connections.sort(key=lambda x: x[2])

        # Step 2. Initialize Union-Find (Disjoint Set Union)
        parent = [i for i in range(n + 1)]  # cities are 1-indexed
        rank = [0] * (n + 1)

        # Find with path compression
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        # Union by rank
        def union(x, y):
            rootX, rootY = find(x), find(y)
            if rootX == rootY:
                return False  # already connected
            if rank[rootX] < rank[rootY]:
                parent[rootX] = rootY
            elif rank[rootX] > rank[rootY]:
                parent[rootY] = rootX
            else:
                parent[rootY] = rootX
                rank[rootX] += 1
            return True

        # Step 3. Kruskal’s algorithm
        total_cost = 0
        edges_used = 0

        for u, v, cost in connections:
            if union(u, v):  # connect two components
                total_cost += cost
                edges_used += 1
                if edges_used == n - 1:  # all cities connected
                    return total_cost

        # Step 4. If not all cities are connected, return -1
        return -1


# @lc code=end
