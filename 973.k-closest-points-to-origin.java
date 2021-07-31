import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                int dis1 = p1[0] * p1[0] + p1[1] * p1[1];
                int dis2 = p2[0] * p2[0] + p2[1] * p2[1];
                return dis2 - dis1;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
// @lc code=end
