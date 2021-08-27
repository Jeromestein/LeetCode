/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 */

// @lc code=start

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        // get sum of all the elements, put it to sum[i+1]
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }

        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            // split the current array into 2 subarray
            int mid = (left + right) / 2;
            // get the number of range sums from two subarray
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int res = n1 + n2;

            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }

                // get the number of range sums in this current array
                res += r - l;
                i++;
            }

            // merge two subarray and make it sorted
            long[] sorted = new long[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int pSort = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    // subarray1 is done
                    sorted[pSort] = sum[p2];
                    pSort++;
                    p2++;
                } else if (p2 > right) {
                    // subarray2 is done
                    sorted[pSort] = sum[p1];
                    pSort++;
                    p1++;
                } else {
                    // ascending order
                    if (sum[p1] < sum[p2]) {
                        sorted[pSort] = sum[p1];
                        pSort++;
                        p1++;
                    } else {
                        sorted[pSort] = sum[p2];
                        pSort++;
                        p2++;
                    }
                }
            }

            // copy back
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }

            return res;
        }
    }
}

// @lc code=end
