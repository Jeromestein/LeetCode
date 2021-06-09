import java.util.ArrayList;

/*
 * @lc app=leetcode id=845 lang=java
 *
 * [845] Longest Mountain in Array
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        ArrayList<Integer> peak = new ArrayList<>();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                peak.add(i);
            }
        }
        if (peak.size() == 0) {
            return 0;
        }

        int maxlen = 3;
        for (Integer p : peak) {
            int left = p, right = p;

            while (left > 0 && arr[left - 1] < arr[left]) {
                left--;
            }
            while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                right++;
            }
            if (right - left + 1 > maxlen)
                maxlen = right - left + 1;
        }

        return maxlen;

    }
}
// @lc code=end
