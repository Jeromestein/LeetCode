import java.sql.Time;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start

// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         int[][] res = new int[k][];
//         PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//             public int compare(int[] p1, int[] p2) {
//                 int dis1 = p1[0] * p1[0] + p1[1] * p1[1];
//                 int dis2 = p2[0] * p2[0] + p2[1] * p2[1];
//                 return dis2 - dis1;
//             }
//         });

//         for (int i = 0; i < points.length; i++) {
//             pq.add(points[i]);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         for (int i = 0; i < k; i++) {
//             res[i] = pq.poll();
//         }

//         return res;
//     }
// }

class Solution {
    Random rand = new Random();

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        // You may return the answer in any order
        // So we can use quick sort method for reference
        random_select(points, 0, n - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void random_select(int[][] points, int left, int right, int k) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivotDist = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        // swap pivot to the rightmost
        swap(points, right, pivotId);

        int i = left;
        for (int j = left; j < right; j++) {
            int jDist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (jDist <= pivotDist) {
                swap(points, i, j);
                i++;
            }
        }

        // swap pivot back to i
        swap(points, i, right);

        // elements in [left, i-1] <= pivot, in [i+1, right] > pivot
        int notGreaterCNT = i - left + 1;
        if (k < notGreaterCNT) {
            random_select(points, left, i - 1, k);
        } else if (k > notGreaterCNT) {
            random_select(points, i + 1, right, k - notGreaterCNT);
        } else {
            return;
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}

// @lc code=end
