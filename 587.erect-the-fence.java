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
        Arrays.sort(trees, new Comparator<int[]>() {
            public int compare(int[] p, int[] q) {
                int x1 = p[0], y1 = p[1], x2 = q[0], y2 = q[1];
                // compare x first, if equal then compare y
                return x1 - x2 == 0 ? y1 - y2 : x1 - x2;
            }
        });

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

        // delete duplicates
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
        int x1 = p[0], y1 = p[1], x2 = q[0], y2 = q[1], x3 = r[0], y3 = r[1];
        // > 0 : r is over the line between p and q
        // < 0 : r is under the line between p and q
        return (y2 - y1) * (x3 - x2) - (x2 - x1) * (y3 - y2);
    }
}

// @lc code=end
