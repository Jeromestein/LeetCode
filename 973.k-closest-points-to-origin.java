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
//         PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
//                 (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

//         for (int i = 0; i < points.length; i++) {
//             pq.add(points[i]);
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         int[][] res = new int[k][];
//         for (int i = 0; i < k; i++) {
//             res[i] = pq.poll();
//         }

//         return res;
//     }
// }

// Average case: pivot is generally near the mid of l and r; 
// therefore we have n + (n/2 + n/4 +...) <= n + (n) = 2 * n = O(n).
// As for worst case: K = n, and points is already sorted by the distance to origin. 
// @Frimish's code will cost n - 1 + ... + 1 = (n - 1) * n / 2 = O(n^2) time.
class Solution {
    // since return the answer in any order
    // we can consider quick sort (quick select)
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length, l = 0, r = len - 1;
        while (l <= r) {
            // one round quick select
            int mid = helper(points, l, r);
            if (mid == K)
                break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        // pick A[l] as pivot,
        // let every e <= pivot on the left side of pivot and e > pivot on the right
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) {
                r--;
            }
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) {
                l++;
            }
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}

// @lc code=end
