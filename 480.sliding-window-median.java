/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int[] window = new int[k];

        boolean even = k % 2 == 0;
        int mid = k / 2;
        int preMid = mid - 1;

        // get the fisrt k elements form nums[] to window[]
        System.arraycopy(nums, 0, window, 0, k);
        Arrays.sort(window);
        result[0] = even ? ((double) window[preMid] + window[mid]) / 2 : window[mid];

        int startIndex = 0;
        while (startIndex < nums.length - k) {
            // remove nums[startIndex], add nums[startIndex + 1 + k - 1]
            // and then sort
            sortedReplace(window, nums[startIndex], nums[startIndex + 1 + k - 1]);
            startIndex++;
            result[startIndex] = even ? ((double) window[preMid] + window[mid]) / 2 : window[mid];
        }
        return result;
    }

    private void sortedReplace(int[] window, int _old, int _new) {
        // System.out.println(_old + " " + _new);
        // for (int i : window) {
        // System.out.print(i + " ");
        // }
        // System.out.println(" ");

        // remove old
        int idx_old = Arrays.binarySearch(window, _old);
        // move window[idx_old + 1...window.length - 1] backward one unit
        System.arraycopy(window, idx_old + 1, window, idx_old, window.length - idx_old - 1);

        // for (int i : window) {
        // System.out.print(i + " ");
        // }
        // System.out.println(" ");

        // insert next
        int lo = 0, hi = window.length - 2;

        // ????
        // find the first element > _new
        while (lo <= hi) {
            // (left + right) / 2 : 9ms
            // (left + right) >>> 1 : 7ms
            int mid = (lo + hi) >>> 1;
            if (window[mid] < _new) {
                // if window[mid]
                lo = mid + 1;
            } else {
                // why mid - 1 ?
                hi = mid - 1;
            }
        }

        // move window[left...window.length - 2] forward one unit
        System.arraycopy(window, lo, window, lo + 1, window.length - lo - 1);
        window[lo] = _new;

        // System.out.println(lo);
        // for (int i : window) {
        // System.out.print(i + " ");
        // }
        // System.out.println(" ");

    }
    // [1,3,-1,-3,5,3,6,7]\n4
}
// @lc code=end
