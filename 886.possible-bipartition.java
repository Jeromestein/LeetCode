/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Unionfind uf = new Unionfind(2 * n);
        int cnt = 0;
        for (int[] d : dislikes) {
            int x = d[0];
            int y = d[1];
            uf.union(x, y + n);
            uf.union(x + n, y);
        }

        for (int i = 1; i <= n; i++) {
            if (uf.find(i) == uf.find(i + n)) {
                return false;
            }
        }

        return true;
    }
}

class Unionfind {
    int[] root;

    public Unionfind(int n) {
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa != bb) {
            root[aa] = bb;
        }
    }
}

// @lc code=end
