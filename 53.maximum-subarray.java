/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

// class Solution {
// struct val{int l,m,r,s;

// val(int l,int m,int r,int s):l(l),m(m),r(r),s(s){}};

// public:
// val dac(int A[], int n) {
// if(n == 1) return val(A[0], A[0], A[0], A[0]);
// val v1 = dac(A, n / 2), v2 = dac(A + n / 2, n - n / 2);
// int l, m, r, s;
// l = max(v1.l, v1.s + v2.l);
// m = max(v1.r + v2.l, max(v1.m, v2.m));
// r = max(v2.r, v1.r + v2.s);
// s = v1.s + v2.s;
// return val(l, m, r, s);
// }

// int maxSubArray(int A[], int n) {
// val v = dac(A, n);
// return v.m;
// }
// };
// @lc code=end
