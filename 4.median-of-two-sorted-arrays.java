/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // make sure m <= n
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);

        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums1Left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = j == n ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left > nums2Right) {
                imax = i - 1;
            } else if (nums2Left > nums1Right) {
                imin = i + 1;
            } else {
                int max_left = Math.max(nums1Left, nums2Left);
                int min_right = Math.min(nums1Right, nums2Right);
                if ((m + n) % 2 == 1)
                    return max_left; // # of left_part = # of right_part + 1;
                else
                    return (max_left + min_right) / 2.0;
            }
        }
        return -1;
    }
    // public double findMedianSortedArrays(int[] A, int[] B) {
    // int m = A.length, n = B.length;
    // if (n == 0 && m == 0) {
    // return 0.0;
    // }
    // int mid1 = (m + n + 1) / 2;
    // int mid2 = (m + n + 2) / 2;
    // // if m+n is even, mid=mid1=mid2;
    // // else mid=(mid1+mid2)/2.0
    // return (getkth(A, 0, B, 0, mid1) + getkth(A, 0, B, 0, mid2)) / 2.0;
    // }

    // // find K-th elements in 2 sorted arrays
    // public double getkth(int[] a, int aStart, int[] b, int bStart, int k) {
    // int m = a.length, n = b.length;
    // if (aStart > m - 1)
    // return b[bStart + k - 1];
    // if (bStart > n - 1)
    // return a[aStart + k - 1];
    // if (k == 1)
    // return Math.min(a[aStart], b[bStart]);

    // int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
    // if (aStart + k / 2 - 1 < m)
    // aMid = a[aStart + k / 2 - 1];
    // if (bStart + k / 2 - 1 < n)
    // bMid = b[bStart + k / 2 - 1];

    // if (aMid < bMid)
    // // Check: aRight + bLeft
    // return getkth(a, aStart + k / 2, b, bStart, k - k / 2);
    // else
    // // Check: bRight + aLeft
    // return getkth(a, aStart, b, bStart + k / 2, k - k / 2);
    // }
}
// @lc code=end
