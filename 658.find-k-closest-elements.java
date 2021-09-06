import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // |a - x| < |b - x|, or
            // |a - x| == |b - x| and a < b
            if (x - A[mid] > A[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(A[left + i]);
        }
        return ans;

    }
}
// @lc code=end
