/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        DSU dsu = new DSU(2 * n);
        for (int[] d : dislikes) {
            int x = d[0];
            int y = d[1];
            dsu.union(x, y + n);
            dsu.union(x + n, y);
        }

        for (int i = 1; i <= n; i++) {
            if (dsu.find(i) == dsu.find(i + n)) {
                return false;
            }
        }

        return true;
    }
}

class DSU {
    int[] root;

    public DSU(int n) {
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (root[x] != x)
            root[x] = find(root[x]);
        return root[x];
    }

    public void union(int a, int b) {
        root[find(a)] = find(b);
    }
}

// @lc code=end
