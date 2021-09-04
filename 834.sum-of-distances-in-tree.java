import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=834 lang=java
 *
 * [834] Sum of Distances in Tree
 */

// @lc code=start

class Solution {
    int[] ans;
    int[] desNodeNum; // desNodeNum[i]: the no. of the nodes in the subtree rooting from node i.
    int[] dp; // dp[i]: the sum of distances between node i and all its descendant nodes.
    List<List<Integer>> adjList;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        desNodeNum = new int[n];
        dp = new int[n];

        // still need to build the adjacent list
        adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return ans;
    }

    public void dfs(int u, int uFather) {
        desNodeNum[u] = 1;
        dp[u] = 0;
        for (int uChild : adjList.get(u)) {
            if (uChild == uFather) {
                continue;
            }
            dfs(uChild, u);
            dp[u] += dp[uChild] + desNodeNum[uChild];
            desNodeNum[u] += desNodeNum[uChild];
        }
    }

    public void dfs2(int u, int uFather) {
        ans[u] = dp[u];
        for (int uChild : adjList.get(u)) {
            if (uChild == uFather) {
                continue;
            }
            // switch u and uChild, consider u as one of the uchild's children
            int pu = dp[u], pv = dp[uChild];
            int su = desNodeNum[u], sv = desNodeNum[uChild];

            dp[u] -= dp[uChild] + desNodeNum[uChild];
            desNodeNum[u] -= desNodeNum[uChild];
            dp[uChild] += dp[u] + desNodeNum[u];
            desNodeNum[uChild] += desNodeNum[u];

            dfs2(uChild, u);

            // switch back
            dp[u] = pu;
            dp[uChild] = pv;
            desNodeNum[u] = su;
            desNodeNum[uChild] = sv;
        }
    }
}

// @lc code=end
