/*
 * @lc app=leetcode id=882 lang=java
 *
 * [882] Reachable Nodes In Subdivided Graph
 */

// @lc code=start
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // adjacent map
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            graph.computeIfAbsent(u, x -> new HashMap()).put(v, weight);
            graph.computeIfAbsent(v, x -> new HashMap()).put(u, weight);
        }

        PriorityQueue<ANode> pq = new PriorityQueue<ANode>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new ANode(0, 0));

        Map<Integer, Integer> dist = new HashMap();
        dist.put(0, 0);

        // [We use the encoding (u, v) = u * N + v.]
        Map<Integer, Integer> used = new HashMap();
        int ans = 0;

        // bfs, walk through all the nodes
        while (!pq.isEmpty()) {
            ANode anode = pq.poll();
            int currNode = anode.node;
            int currNodeDist = anode.dist;

            if (currNodeDist > dist.getOrDefault(currNode, 0))
                continue;
            // Each node is only visited once. We've reached
            // a node in our original graph.
            ans++;

            // for like node 0 itself
            if (!graph.containsKey(currNode))
                continue;

            // walk through all the next nodes
            for (int nextNode : graph.get(currNode).keySet()) {
                // maxMoves - currNodeDist: how much further we can walk from this node;
                // weight: how many new nodes there are on this edge.
                // val: the maximum utilization of this edge.
                int weight = graph.get(currNode).get(nextNode);
                int val = Math.min(weight, maxMoves - currNodeDist);
                used.put(n * currNode + nextNode, val);

                // nextNodeDist: the total distance for node 0 to reach 'nextNode'
                int nextNodeDist = currNodeDist + weight + 1;
                if (nextNodeDist < dist.getOrDefault(nextNode, maxMoves + 1)) {
                    pq.offer(new ANode(nextNode, nextNodeDist));
                    dist.put(nextNode, nextNodeDist);
                }
            }
        }

        // At the end, each edge (u, v, weight) can be used with a maximum
        // of w new nodes: a max of used[u, v] nodes from one side,
        // and used[v, u] nodes from the other.
        // [We use the encoding (u, v) = u * N + v.]
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            ans += Math.min(weight, used.getOrDefault(u * n + v, 0) + used.getOrDefault(v * n + u, 0));
        }

        return ans;
    }
}

class ANode {
    int node, dist;

    ANode(int n, int d) {
        node = n;
        dist = d;
    }
}

// @lc code=end
