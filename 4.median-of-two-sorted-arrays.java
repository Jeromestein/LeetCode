/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (n == 0 && m == 0) {
            return 0.0;
        }
        int mid1 = (m + n + 1) / 2;
        int mid2 = (m + n + 2) / 2;
        // if m+n is even, mid=mid1=mid2;
        // else mid=(mid1+mid2)/2.0
        return (getkth(A, 0, B, 0, mid1) + getkth(A, 0, B, 0, mid2)) / 2.0;
    }

    // find K-th elements in 2 sorted arrays
    public double getkth(int[] a, int aStart, int[] b, int bStart, int k) {
        int m = a.length, n = b.length;
        if (aStart > m - 1)
            return b[bStart + k - 1];
        if (bStart > n - 1)
            return a[aStart + k - 1];
        if (k == 1)
            return Math.min(a[aStart], b[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < m)
            aMid = a[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < n)
            bMid = b[bStart + k / 2 - 1];

        if (aMid < bMid)
            // Check: aRight + bLeft
            return getkth(a, aStart + k / 2, b, bStart, k - k / 2);
        else
            // Check: bRight + aLeft
            return getkth(a, aStart, b, bStart + k / 2, k - k / 2);
    }
}
// @lc code=end
