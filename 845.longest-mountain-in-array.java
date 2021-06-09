import java.util.ArrayList;

/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */

// @lc code=start
class Solution {
    // public int longestMountain(int[] arr) {
    // if (arr.length < 3) {
    // return 0;
    // }
    // int maxlen = 0;
    // int left = 0, right = 0;

    // while (left < arr.length - 1) {
    // right = left;
    // if (right < arr.length - 1 && arr[right] < arr[right + 1]) {
    // while (right < arr.length - 1 && arr[right] < arr[right + 1])
    // right++;

    // if (right < arr.length - 1 && arr[right] > arr[right + 1]) {
    // // it is a peak
    // while (right < arr.length - 1 && arr[right] > arr[right + 1])
    // right++;

    // maxlen = Math.max(maxlen, right - left + 1);
    // }
    // }

    // left = Math.max(right, left + 1);
    // }

    // return maxlen;
    // }
    public int longestMountain(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i])
                up = down = 0;
            if (A[i - 1] < A[i])
                up++;
            if (A[i - 1] > A[i])
                down++;
            if (up > 0 && down > 0 && up + down + 1 > res)
                res = up + down + 1;
        }
        return res;
    }
}
// @lc code=end
