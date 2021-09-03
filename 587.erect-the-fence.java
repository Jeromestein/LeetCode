/*
 * @lc app=leetcode id=587 lang=java
 *
 * [587] Erect the Fence
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class Solution {

    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);

        Stack<int[]> hull = new Stack<>();
        for (int[] tree : trees) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), tree) > 0) {
                hull.pop();
            }
            hull.push(tree);
        }
        hull.pop();
        for (int i = trees.length - 1; i >= 0; i--) {
            while (hull.size() >= 2
                    && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), trees[i]) > 0) {
                hull.pop();
            }
            hull.push(trees[i]);
        }

        // 去重
        Set<Point> hashSet = new HashSet<>();
        for (int[] tree : hull) {
            hashSet.add(new Point(tree[0], tree[1]));
        }

        int index = 0;
        int[][] res = new int[hashSet.size()][2];
        for (Point tree : hashSet) {
            res[index] = new int[] { tree.a, tree.b };
            index++;
        }
        return res;
    }

    class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return a == point.a && b == point.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
}

// @lc code=end
