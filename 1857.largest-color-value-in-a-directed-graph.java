import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=1857 lang=java
 *
 * [1857] Largest Color Value in a Directed Graph
 */

// @lc code=start

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        // 1. Build the Graph and Indegree array
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = colors.length();
        char[] color = colors.toCharArray();

        for (int i = 0; i < n; i++)
            graph.add(i, new ArrayList<>());
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
            // directed graph
            graph.get(u).add(v);
        }

        // 2. color count map. dp
        // dp[i][j] is the maximum count of j color from the ancester nodes to node i
        int[][] dp = new int[n][26];

        // 3.Khans Algorithm (Iterative Topological Sort)
        // detect cycle and fill out dp[][]
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i][color[i] - 'a'] = 1;
            }
        }

        int res = 0;
        int seen = 0;

        while (q.size() > 0) {
            int currNode = q.pop();
            seen++;

            int max = getMax(dp[currNode]);
            res = Math.max(res, max);

            for (int nextNode : graph.get(currNode)) {
                // update the map of next node
                for (int i = 0; i < 26; i++) {
                    int isColori = color[nextNode] - 'a' == i ? 1 : 0;
                    dp[nextNode][i] = Math.max(dp[nextNode][i], dp[currNode][i] + isColori);
                }
                indegree[nextNode]--;

                if (indegree[nextNode] == 0) {
                    q.add(nextNode);
                }
            }
        }
        // if seen!=n means cycle is there
        // "a"
        // [[0,0]]
        // n=0 != 1
        return seen == n ? res : -1;
    }

    private int getMax(int[] num) {
        int max = num[0];
        for (int n : num) {
            max = Math.max(n, max);
        }
        return max;
    }

}

// @lc code=end
